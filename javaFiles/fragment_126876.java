import groovy.transform.CompileStatic
import ratpack.exec.Promise
import ratpack.func.Function
import ratpack.groovy.handling.GroovyChainAction
import ratpack.groovy.test.handling.GroovyRequestFixture
import ratpack.guice.Guice
import ratpack.http.Status
import ratpack.jackson.internal.DefaultJsonRender
import ratpack.registry.Registry
import ratpack.session.Session
import ratpack.session.SessionModule
import spock.lang.Specification

import static ratpack.jackson.Jackson.json

class SessionChainTest extends Specification {

    static Function<Registry, Registry> guiceRegistry = Guice.registry { bindings ->
        bindings.module(new SessionModule())
    }

    GroovyChainAction sessionChain = new GroovyChainAction() {
        @Override
        @CompileStatic
        void execute() throws Exception {
            register(guiceRegistry.apply(registry))

            get('foo') {
                Session s = get Session

                s.get('test').map { Optional<String> o ->
                    o.orElse(null)
                }.flatMap { value ->
                    Promise.value(value)
                }.then {
                    render(json([message: it]))
                }
            }
        }
    }

    def "should get session"() {
        given:
        def result = GroovyRequestFixture.handle(sessionChain) {
            uri 'foo'
            method 'GET'
        }

        expect:
        result.status == Status.OK

        and:
        result.rendered(DefaultJsonRender).object == [message: null]

    }
}
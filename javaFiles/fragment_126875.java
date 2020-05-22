import groovy.transform.CompileStatic
import ratpack.exec.Promise
import ratpack.groovy.handling.GroovyChainAction
import ratpack.groovy.test.handling.GroovyRequestFixture
import ratpack.http.Status
import ratpack.jackson.internal.DefaultJsonRender
import ratpack.session.Session
import spock.lang.Specification

import static ratpack.jackson.Jackson.json

class SessionChainTest extends Specification {

    Session session = Mock(Session) {
        get('test') >> Promise.value(Optional.of('Lorem ipsum'))
    }

    GroovyChainAction sessionChain = new GroovyChainAction() {
        @Override
        @CompileStatic
        void execute() throws Exception {
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
            registry { r ->
                r.add(Session, session)
            }
        }

        expect:
        result.status == Status.OK

        and:
        result.rendered(DefaultJsonRender).object == [message: 'Lorem ipsum']

    }
}
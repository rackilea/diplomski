import grails.compiler.GrailsCompileStatic
import grails.gsp.PageRenderer

@GrailsCompileStatic
class StaticTestTagLib {

    static namespace = "staticTest"

    PageRenderer groovyPageRenderer

    String myTag = { Map attrs ->
        out << groovyPageRenderer.render(template: '/templates/myTemplate', model: [...])

    }
}
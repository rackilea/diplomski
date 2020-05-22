import grails.converters.JSON

class TestStuffController {

    def index() {
        println 'index'

    }

    def jsonUrl() {
        if (!true) {
            render([success: false, messages: 'bad stuff'] as JSON)
            return
        }
        render([success: true] as JSON)
    }
}
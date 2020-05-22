import com.charter.aesd.testcommons.RESTSpecification
import groovyx.net.http.HttpResponseDecorator


class TestIT extends RESTSpecification{

    def BASE_URL = "/test"
    def "Get test"(){
        when:
        HttpResponseDecorator response = getRestClient().get([path:"$BASE_URL"+"/123"])

        then:
            response.status >=200 && response.status < 400
    }

    @Override
    String getBaseUrl() {
        return 'http://localhost:8889/'
    }
}
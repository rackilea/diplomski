import net.example.MyClass
import com.fasterxml.jackson.databind.ObjectMapper

class MyService(val objectMapper: ObjectMapper) {

    def getMyClassAsJson() {
        val result: MyClass = // calling a service which provides the MyClass object
        return objectMapper.writeValueAsString(result)
    }
}
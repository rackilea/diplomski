import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class EndpointController {

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @GetMapping("endpoints/{name}")
    public String show(@PathVariable("name") String name) {
        String output = name + "Not Found";
        Map<RequestMappingInfo, HandlerMethod> methods = this.handlerMapping.getHandlerMethods();

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : methods.entrySet()) {
            if (entry.getKey().getName() != null && entry.getKey().getName().equals(name)) {
                output = entry.getKey().getName() + " : " + entry.getKey();
                break;
            }
        }
        return output;
    }
}
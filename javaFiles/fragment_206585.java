import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
@ConfigurationProperties(prefix="this.is")
class WithValueAnnotation {

    private List<String> array;

    public List<String> getArray(){
        return this.array;
    }

    public void setArray(List<String> array){
        this.array = array;
    }

    @RequestMapping(value = "/test_cfg", method = { RequestMethod.GET,
            RequestMethod.POST }, produces = "application/json")
    public String test() {

        System.err.println(array);

        return array.toString();
    }
}
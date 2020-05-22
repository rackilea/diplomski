import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.xyz.ExampleClass;
import test.xyz.ValidateAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;

@Controller
public class ExampleController {
    @RequestMapping(value="test-endpoint", method= RequestMethod.GET)
    public @ResponseBody
    Object testMethod(@Valid ExampleClass exampleClass, Errors errors) {
        return Collections.singletonMap("success", true);
    }


    @InitBinder
    public void initBinder(WebDataBinder binder, HttpServletRequest request) throws IllegalAccessException, InstantiationException {
        Class<?> targetClass = binder.getTarget().getClass();
        if(targetClass.isAnnotationPresent(ValidateAnnotation.class)) {
            ValidateAnnotation annotation = targetClass.getAnnotation(ValidateAnnotation.class);
            Class<? extends Validator> value = annotation.value();
            Validator validator = value.newInstance();
            binder.setValidator(validator);
        }
    }
}
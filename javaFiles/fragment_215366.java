import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
...
import javax.validation.Valid;

@Controller
public class RegistrationController
{
    @InitBinder
    protected void initBinder(WebDataBinder binder) 
    {
        binder.setMessageCodesResolver(new MessageCodesResolver());
        binder.setValidator(new RegistrationValidator());
    }

    @RequestMapping(value="/userRegistration.html", method = RequestMethod.POST)
    public String processRegistrationForm(@Valid Registration registration, BindingResult result, HttpServletRequest request) 
{
         if(result.hasErrors())
         {
            return "registration"; // the name of the view
         }

         ...
    }
}
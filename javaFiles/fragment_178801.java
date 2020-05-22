package MylController;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
/**
 *
 * @author Juned Ansari
 */
@Controller
public class mainController {
    @RequestMapping("/main")
    public ModelAndView hithere() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("welcomeMessage", "Hi there");

        return mav;
    }
}
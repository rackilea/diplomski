@Controller
@RequestMapping("/errorEncountered.htm")
public class ErrorHandlerController {
    private MailService mailService;

    @RequestMapping(method = RequestMethod.GET)
    public String handleGet(HttpServletRequest request) {
            // The Servlet spec guarantees this attribute will be available
            Throwable exception = (Throwable) request
                    .getAttribute("javax.servlet.error.exception");

            .
            .
            .
            mailService.sendMail();
        }
    }
}
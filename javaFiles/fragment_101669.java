@Controller
public class WorkaroundBasicErrorController extends BasicErrorController {
    //default constructor from ErrorMvcAutoConfiguration
    public DefaultBasicErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties,
                                       ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider) {
        super(errorAttributes, serverProperties.getError(), errorViewResolversProvider.getIfAvailable());
    }

    @RequestMapping
    @ResponseBody
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        String format = request.getParameter("format");

        return (StringUtils.containsAny(format, "json", "xml"))
            ? super.error(request)
            : new ResponseEntity<>(getStatus(request)); //neglect body for plain formats
    }
}
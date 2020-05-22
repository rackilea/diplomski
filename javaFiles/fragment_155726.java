@Controller
@EnableWebMvc
public class StreamRecordsController extends WebMvcConfigurerAdapter{

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(100000000); //in milliseconds (20 hours)
        super.configureAsyncSupport(configurer);
    }

    @RequestMapping(value = "/streamrecords/{elementname}", method = RequestMethod.GET, 
                    produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<StreamingResponseBody> streamRecords(
            HttpServletRequest request, 
            HttpServletResponse response,
            @PathVariable(value = "elementname", required = true) String elementName,
            @RequestParam(value = "customerid", required = true) long customerId,
            @RequestParam(value = "userid", required = true) long userId) throws Exception {
            StreamingResponseBody responseBody = outputStream -> {
                    /**
                    * 1. FETCH Data from MongoDB using dbcursor and convert to json using pagination.
                    * 2. Write json to outputStream.
                    */
                };
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=sample.json")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(responseBody);
        }

}
@Autowired
API2Caller api2Caller;

@RequestMapping(
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
        path = "api/api1",
        method = RequestMethod.POST,
        produces = MediaType.ALL_VALUE
)
@ResponseStatus(HttpStatus.ACCEPTED)
public void api1CallBack(@RequestBody String requestBody, HttpServletRequest request) throws IOException, GeneralSecurityException, URISyntaxException {
    api2Caller.callApi2(requestBody);
}
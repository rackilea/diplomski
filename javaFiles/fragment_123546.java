@RequestMapping(value = "/endpoint/add-with-cert", method = RequestMethod.POST)
public @ResponseBody GenericFormResponse excecuteWithCert(
        WebRequest wreq,
        @RequestParam("epName") String epName,
        @RequestParam("ipAddr") String ipAddr,
        @RequestParam("useDefault") boolean useDefault,
        @RequestParam("certFile") MultipartFile certFile) throws Exception {
    LOGGER.debug("received request for endpoint creation with certificate");
    GenericFormResponse response = new GenericFormResponse();
    SessionManager sessionMgr = new SessionManager(wreq);
    if(!sessionMgr.isLoggedIn()) {
        response.setSuccess(false);
        response.setGlobalErrorCode("not_logged_in");
        return response;
    }
    ...............
}

@RequestMapping(value = "/endpoint/add", method = RequestMethod.POST)
public @ResponseBody GenericFormResponse excecuteWithOutCert(
        WebRequest wreq,
        @RequestParam("epName") String epName,
        @RequestParam("ipAddr") String ipAddr,
        @RequestParam("useDefault") boolean useDefault) throws Exception {
    LOGGER.debug("received request for endpoint creation  without certificate");
    ...............
}
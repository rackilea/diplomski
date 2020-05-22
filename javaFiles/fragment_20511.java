@WebMethod(operationName = "activate")
public String activate(
        @WebParam(name = "userEdipi") String userEdipi,
        @WebParam(name = "adminEdipi") String adminEdipi,
        @WebParam(name = "sarId") String sarId) {
    try {
        String response = acctmgrInterface.activate(userEdipi, adminEdipi, sarId);
        return response;
    } catch (Exception e) {
        logger.error("AcctmgrWebService.activate(): error - have your admin check the server logs");
        logger.error(ExceptionUtils.getStackTrace(e.fillInStackTrace()));
        return e.toString();
    }
}
public MyResponse getMyResponse(MyRequest request) throws Exception
{
    MyResponse response = new MyResponse();
    response=Service.getRes(request);
    try {
        log(request,response);
    }
    catch (Exception e) {
        // Do something with the error?
    }
    finally {
        // No matter if there is an error or not, the following will be executed.
        return response;
    }
}
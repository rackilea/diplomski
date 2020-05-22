WebService service = new WebService();
service.getUrl("www.test.com", yourContext, new WebServiceCallback(){

    @Override
    public void onFailure(){}

    @Override
    public void onSuccess(String url){
        yourAlreadyDeclaredString = url;
        // do smth with it 
    }
});
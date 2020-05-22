public Response getResponse(Request request){
    Response aResponse = null;

    if(request instanceof SetPinResponse) {
        aResponse = new SetPinResponse((SetPinRequest) request);
    } else if (request instanceof MakePaymentResposne) {
        aResponse =  new MakePaymentResposne((MakePaymentRequest) request);
    }

    return aResponse;
}
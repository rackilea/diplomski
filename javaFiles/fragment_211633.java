interface RequestSender {
      Response send(String addr,msgBody)
}

class RequestSenderImpl implements RequestSender {
    public Response send(String addr,msgBody) {
       Request request = Request.Post(address).bodyString(messageBody,ContentType.APPLICATION_JSON);
       Response response = request.execute();
       return response;
    }
}
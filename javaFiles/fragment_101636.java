<%
        final ServletOutputStream finalOut = out; // create final reference

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        Future<Integer> f = asyncHttpClient.prepareGet("http://www.ning.com/")
          .execute(new AsyncCompletionHandler<Integer>(){

        public STATE onStatusReceived(HttpResponseStatus respstat)throws Exception{
                    ***//error occurs in next line***
            finalOut.println(respstat.getStatusText());  //use final reference
            return STATE.CONTINUE;
        }
        @Override
        public Integer onCompleted(Response response) throws Exception{
            // Do something with the Response
            out.println(response.getStatusCode());
            return response.getStatusCode();
        }

        @Override
        public void onThrowable(Throwable t){
            // Something wrong happened.
        }
    });
  %>
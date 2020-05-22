Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(SERVER_URL).path(API_PATH);

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    // set headers and other stuff

    AsyncInvoker asyncInvoker = invocationBuilder.async();

    asyncInvoker.get(new InvocationCallback<Response>() {

        @Override
        public void completed(Response response) {
            if (response.getStatusInfo().equals(Status.OK)) {
               // parse the response in success scenario
            } else {
               // parse the response if error response is received from server
            }
            client.close();
        }

        @Override
        public void failed(Throwable throwable) {
            System.out.println("An error occurred while calling API");
            throwable.printStackTrace();
            client.close();
        }
    });
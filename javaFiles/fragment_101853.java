.addListener(new ResponseListener<Response>() {
        public void onReceive(Response response) {
            final Annotation[] annotations = response.getClass().getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("annotation.toString() = " + annotation.toString());
            }
        }
    });
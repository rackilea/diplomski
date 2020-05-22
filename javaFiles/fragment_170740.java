client.addResponseInterceptor(new HttpResponseInterceptor() {
                    @Override
                    public void process(HttpResponse response, HttpContext context) {
                            response.setEntity(new InflatingEntity(response.getEntity()));

                    }

                });
GoogleCredential credential = new GoogleCredential.Builder()
.setTransport(this.TRANSPORT).setJsonFactory(this.JSON_FACTORY)
.setClientSecrets(Constants.CLIENT_ID, Constants.CLIENT_SECRET).setRequestInitializer((new HttpRequestInitializer(){
                @Override
                public void initialize(HttpRequest request)
                        throws IOException {
                    request.getHeaders().put("Authorization", "Bearer " + accessToken);
                }
            })).build()
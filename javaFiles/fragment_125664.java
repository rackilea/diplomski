private static HttpUrlConnectorProvider buildHttpUrlConnectorProvider(){
             HttpUrlConnectorProvider.ConnectionFactory factory = new HttpUrlConnectorProvider.ConnectionFactory() {
                    @Override
                    public HttpURLConnection getConnection(URL url) throws IOException {
                        HttpURLConnection result = (HttpURLConnection) url.openConnection();
                        result.setChunkedStreamingMode(1024);
                        return result;
                    }
                };
             return new HttpUrlConnectorProvider().connectionFactory(factory);
        }
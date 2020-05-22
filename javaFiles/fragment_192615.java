public static void main(String[] args) {
     // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
            public X509Certificate[] getAcceptedIssuers(){return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType){}
            public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};

        // Install the all-trusting trust manager
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            System.out.println(e);
        }

        Client client = ClientBuilder.newBuilder().sslContext(sc).build();

        Response exchange = client.target("https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=MSFT&apikey=B1KLWMIAGSG0UWYD") 

                              .request(MediaType.APPLICATION_JSON)
                              .get(Response.class);

        System.out.println(exchange.getMetaData());
        for (StockQuote sq : exchange.getStockQuotes()) {
            System.out.println(sq);
        }


        client.close();
    }
new Thread( new Runnable() {
        @Override
        public void run() {
            HttpResponse response = null;
            //String classID = "CSD2334";
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI("http://localhost:8080/de.vogella.jersey.first/resources/hello/ids/CSD2334"));
                response = client.execute(request);
                System.out.println(response.toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return response.toString();
        }
    }).start();
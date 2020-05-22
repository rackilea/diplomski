try {
            URL url=new URL(urladdress);


            HttpURLConnection con= (HttpURLConnection)url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestMethod("POST")
            con.setDoOutput(true);

            con.setDoInput(true);
            return con;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
InputStream is = response.getEntity().getContent();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    String line;
    while((line = br.readLine()) != null)
    {
        //Do something with each line
    }
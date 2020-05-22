if(con==null) {
            Toast.makeText(ctx,"Connection is null",Toast.LENGTH_LONG).show();


        }

    try{
        InputStream is = new BufferedInputStream(con.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;
        StringBuffer jsonData= new StringBuffer();

        while ((line=br.readLine())!=null)
        {

            jsonData.append(line+"/n");
        }
        br.close();
        is.close();
        return jsonData.toString();

    } catch (IOException e) {
        e.printStackTrace();
    }
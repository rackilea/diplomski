BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(input, "UTF-8"));
    String line;
    StringBuilder clientData=new StringBuilder();
    while ((line=bufferedReader.readLine()) != null)
    {
        clientData.append(line);
    }
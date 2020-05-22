public static String getSource(String link){
    try{
        URL u = new URL(link);
        URLConnection con = u.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer buffer = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            buffer.append(inputLine);
        in.close();
        return buffer.toString();
    }catch(Exception e){
        return null;
    }
}
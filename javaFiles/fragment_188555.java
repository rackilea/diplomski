public static void main(String[] args) throws Exception
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please enter a postcode:");
    String postcode=reader.readLine();
    StringBuffer input=new StringBuffer();
    String data=null;
    String latLong=null;
    String link="http://maps.google.com/maps?q="+URLEncoder.encode(postcode, "UTF-8");
    URL url=new URL(link);
    HttpURLConnection connection=(HttpURLConnection)url.openConnection();
    BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
    if(connection.getResponseCode()==200)
    {
      System.out.println("Success");
      while((data=br.readLine())!=null)
        input.append(data);
    }
    int x=input.indexOf("lat:");
    int y=input.indexOf("}",x);
    latLong=input.substring(x,y);
    latLong=latLong.replaceAll("lat:","");
    latLong=latLong.replaceAll("lng:","");
    System.out.println(latLong);
    String[] array=latLong.split(",");
    System.out.println("Latitude: "+array[0]+" and Longitude: "+array[1]+" for "+an>+postcode);
  }
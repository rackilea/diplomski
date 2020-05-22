try {
     URL blogPostURL=new URL("URL...");
     URLConnection connection=blogPostURL.openConnection();
     BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
     String responseData;
     while ((responseData = reader.readLine()) != null){ 
             Log.i("TAG", responseData);
     }
     reader.close();
}catch (MalformedURLException e) {
     Log.i("TAG", "MalformedURLException Error: "+e.getMessage());
} catch (IOException e) {
     Log.i("TAG", "IOException Error: "+e.getMessage());
} catch (Exception e) {
     Log.i("TAG", "Exception Error: "+e);
}
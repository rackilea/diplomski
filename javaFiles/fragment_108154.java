private void checkNextPage(ArrayList<String> listTokenFunction, String urlGoogleToken){

   // initialize if null
   if(listTokenFunction == null) {
       listTokenFunction = new ArrayList<String>();
   }

   try
   {
       /* I AM DOING SOME STUFF */

       if (jsonObj.has("next_page_token")){
          String next_page_token = (String) jsonObj.get("next_page_token");
          listTokenFunction.add(next_page_token); // I WANT TO SAVE THIS LIST
          String result = urlGoogleToken.split("&pagetoken=")[0];
          String urlGoogleMaps2 = result+"&pagetoken="+next_page_token; 
          checkNextPage(urlGoogleMaps2, listTokenFunction); // CALL THE FUNCTION
       } else {
          System.out.println("ELSE");
       }
   } catch (Exception e) {
          e.printStackTrace();
   }

}
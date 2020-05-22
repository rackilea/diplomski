protected Void doInBackground(Void...params){ 

   InputStream is=null;
   String result="";
   try{

   records.clear(); //clear the list before re-populating

   httpclient=new DefaultHttpClient();
      httppost= new HttpPost("http://necrecords.16mb.com/getproducts.php");
   response=httpclient.execute(httppost);         
         HttpEntity entity = response.getEntity();
         is = entity.getContent();

   }catch(Exception e){
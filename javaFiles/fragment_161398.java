try {      
       FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
        fos.write(myJSONString.getBytes());
         fos.close();      
       //Log.d(TAG, "Written to file");  
     } 
   catch (Exception e)
     {    
        Log.d(TAG, "cought");     
         e.printStackTrace(); 
      }
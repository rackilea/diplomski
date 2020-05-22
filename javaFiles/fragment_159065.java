//convert response to string
   try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"),8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
              sb.append(line + "\n");
        }
        is.close();         
        result=sb.toString();
   }catch(Exception e){
        Log.e("ERROR", "Error converting result "+e.toString());
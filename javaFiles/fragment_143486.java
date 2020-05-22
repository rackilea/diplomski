while(cur.hasNext() && !isStopped()) {
String json = cur.next().toString(); 
JSONObject jObject = new JSONObject(json);
if(jObject.has("Otype")){
       System.out.print(jObject.getString("Otype"));
   }//end of if
}//end of while
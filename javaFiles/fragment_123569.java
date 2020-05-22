Iterator<String> inputjsonkeys = inputjson.keys();
    while(inputjsonkeys.hasNext())
    {

     String key = inputjsonkeys.next();
      String val = null;
        try{
             JSONObject inputvalue = inputjson.getJSONObject(key);

             if(outputjson.has(key))
             {
                 try{
                    JSONObject outputvalue = outputjson.getJSONObject(key);
                    if( checksubsetobject(outputvalue,inputvalue) == false)
                        {
                          return false;
                        }
                    }
                 catch(Exception e)
                 {
                     return false;
                 }

             }
             else
             {
                 return false;
             }
        }catch(Exception e){
            val =inputjson.get(key).toString();


        }

        if(val != null){
        if (checksubsetstring(outputjson,key,val)==false)
            {
              return false;
            }
        }

    }

    return true;

}
public boolean checksubsetstring(JSONObject outputjson, String key, String val) throws JSONException {


        try{
            if(val.contains("[")&&val.contains("]"))
            {

                Pattern p = Pattern.compile("\\[");

                   Matcher m = p.matcher(val); 
                   val = m.replaceAll("");

                   Pattern p2 = Pattern.compile("\\]");
                   Matcher m2 = p2.matcher(val); 
                   val = m2.replaceAll("");

                   Pattern p5 = Pattern.compile("\\{");
                   Matcher m5 = p5.matcher(val); 
                   val = m5.replaceAll("");

                   Pattern p6 = Pattern.compile("\\}");
                   Matcher m6 = p6.matcher(val); 
                   val = m6.replaceAll("");

                 /*  Pattern p9 = Pattern.compile("\"");
                   Matcher m9 = p9.matcher(val); 
                   val = m9.replaceAll("");*/

                 //  System.out.println("value1  "+val);

                String valarray[] = val.split(",");
                String outputarraystring = outputjson.get(key).toString();

                if(!outputarraystring.contains("[")&&outputarraystring.contains("]"))
                {
                    return false;
                }
                else
                {

                    Pattern p3 = Pattern.compile("\\[");

                       Matcher m3 = p3.matcher(outputarraystring); 
                       outputarraystring = m3.replaceAll("");

                       Pattern p4 = Pattern.compile("\\]");
                       Matcher m4 = p4.matcher(outputarraystring); 
                       outputarraystring = m4.replaceAll("");

                       Pattern p7 = Pattern.compile("\\{");
                       Matcher m7 = p7.matcher(outputarraystring); 
                       outputarraystring = m7.replaceAll("");

                       Pattern p8 = Pattern.compile("\\}");
                       Matcher m8 = p8.matcher(outputarraystring); 
                       outputarraystring = m8.replaceAll("");

                    /*   Pattern p9 = Pattern.compile("\"");
                       Matcher m9 = p9.matcher(val); 
                       val = m9.replaceAll("");*/

                    String outputarray[] = outputarraystring.split(",");
                     /* for(int i=0; i < valarray.length; i++){
                            System.out.println(valarray[i]);
                    }*/
            //      if (Arrays.equals(valarray, outputarray))
                    Set set = new HashSet(Arrays.asList(outputarray)); 
                    Set set2 = new HashSet(Arrays.asList(valarray)); 
                    if (set.containsAll(set2))
                       return true;
                    else
                        return false;

                }

        }
        else{ 
                    if(val.equals(outputjson.get(key).toString()))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
            }
   }

    catch(Exception e){
        return false;
    }


}
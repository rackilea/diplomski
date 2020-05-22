public class DeserializeExample{

    MyDeserialParent[] myDeserialParents;

    static String json = "{\n" +
            "    \"myDeserialParents\" : [\n" +
            "        {\n" +
            "            \"otherProp\": \"lala\"," +
            "            \"type\": \"value\", //used in a TypeAdapter to choose child implementation\n" +
            "            \"childProp1\": \"1\",\n" +
            "            \"childProp2\": \"2\"\n" +
            "         }\n" +
            "     ]\n" +
            "}";


    public static void main( String[] args ){
        Gson gson = new GsonBuilder().registerTypeAdapter( MyDeserialParent.class, new MyParentAdapter() ).create();
        DeserializeExample result = gson.fromJson( json, DeserializeExample.class );
        System.out.println( gson.toJson( result ));
        // output: 
        // {"myDeserialParents":[{"mSerialChild":{"childProp1":"1","childProp2":"2"},"otherProp":"lala"}]}
    }//end main

}//end class
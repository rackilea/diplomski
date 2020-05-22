public class MyParentAdapter implements JsonDeserializer<MyDeserialParent>{

    private static Gson gson = new GsonBuilder().create();
    // here is the trick: keep a map between "type" and the typetoken of the actual child class
    private static final Map<String, Type> CHILDREN_TO_TYPETOKEN;

    static{
        // initialize the mapping once
        CHILDREN_TO_TYPETOKEN = new TreeMap<>();
        CHILDREN_TO_TYPETOKEN.put( "value", new TypeToken<MyChild1>(){}.getType() );
    }


    @Override
    public MyDeserialParent deserialize( JsonElement json, Type t, JsonDeserializationContext
            jsonDeserializationContext ) throws JsonParseException{
        try{
            // first, get the parent
            MyDeserialParent parent = gson.fromJson( json, MyDeserialParent.class );
            // get the child using the type parameter
            String type = ((JsonObject)json).get( "type" ).getAsString();
            parent.mSerialChild = gson.fromJson( json, CHILDREN_TO_TYPETOKEN.get( type ) );
            return parent;

        }catch( Exception e ){
            e.printStackTrace();
        }
        return null;
    }
}
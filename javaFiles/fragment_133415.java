String rawJson = "{\"a\":{\"removeme\":\"unwanted\",\"b\":{\"c\":{\"removeme\":{\"x\":1},\"d\":{\"e\":123}}}}}";

final Gson gson = new GsonBuilder().create();
JsonReader reader = gson.newJsonReader( new StringReader( rawJson ) );

StringWriter outWriter = new StringWriter();
JsonWriter writer = gson.newJsonWriter( outWriter );

JsonStreamFilter.streamFilter( reader, writer, Arrays.asList( "removeme" ) );

System.out.println( rawJson );
System.out.println( outWriter.toString() );
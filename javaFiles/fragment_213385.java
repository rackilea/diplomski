public void writeToJson( Hisab h ) {
    // I am assuming this string has the current Json. Get this from file.
    String currentJsonString = "Some Json, you got from file";

    Gson gson=new GsonBuilder().setPrettyPrinting().create();

    JsonCollection jsonColl = gson.fromJson( currentJsonString, JsonCollection.class );

    // Add your hisab to the collection.
    jsonColl.addHisab( h );

    // Now write this string to file
    String newJsonString =gson.toJson( jsonColl );

    System.out.print( newJsonString );

}
@Override
public RealmPerson read(JsonReader in) throws IOException {
    RealmPerson rList = new RealmPerson();
    in.beginObject();
    String name = "";
    while (in.hasNext()) {
        name = in.nextName();

        if (name.equals("userId")) {
            String userId = in.nextString();
            // update rList here 
        } else if (name.equals("otherStuff")) {
            // since otherStuff is a RealmList of RealmStrings,
            // your json data would be an array
            // You would need to loop through the array to retrieve 
            // the json objects
            in.beginArray();
            while (in.hasNext()) {
                // begin each object in the array
                in.beginObject();
                name = in.nextName();
                // the RealmString object has just one property called "value"
                // (according to the code snippet in your question)
                if (name.equals("val")) {
                    String val = in.nextString();
                     // update rList here 
                } else {
                    in.skipValue();
                }
                in.endObject();
            }
            in.endArray();
        } else {
            in.skipValue();
        }
    }
    in.endObject();


    return rList;
}
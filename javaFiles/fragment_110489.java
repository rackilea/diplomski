DBCursor cursorTotal = coll.find(obje);

    while (cursorTotal.hasNext()) {

    DBObject curNext = cursorTotal.next();

            String res=curNext.toString();
           JsonElement jelement = new JsonParser().parse(res);
            JsonObject  jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject("list");
            JsonArray jarray = jobject.getAsJsonArray("myList");
            jobject = jarray.get(0).getAsJsonObject();
            String result = jobject.get("location").getAsString();


            System.out.println("all places::"+result);
}
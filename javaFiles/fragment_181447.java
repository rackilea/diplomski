JsonParser parser  = new JsonParser();
    JsonElement notes  = parser.parse(s);
    JsonArray notesArr = notes.getAsJsonArray();
    for (int i = 0; i < notesArr.size(); i++) {
        // get your jsonobject 
        JsonObject obj = notesArr.get(i).getAsJsonObject();

       // do the same for the rest of the elements like date , author ,authorId
        String id,noteText,author;

        // fetch data from object
        id       = obj.get("id").getAsString();
        noteText = obj.get("noteText").getAsString();
        author   = obj.get("author").getAsString();

        // Store these values in list or objects you want

        System.out.println(id);
        System.out.println(noteText);
        System.out.println(author);
    }
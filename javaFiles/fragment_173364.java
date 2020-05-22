ParseQuery<ParseObject> query = ParseQuery.getQuery("mytable");
query.whereEqualTo("Title", "Adrians Book");

List<ParseObject> results = null;

 try {
        results = query.find();
        if(!results.isEmpty()) {
        String objectId = results.get(0).getObjectId();
        System.out.println(objectId);
        }

    } catch (com.parse4cn1.ParseException e) {

        Dialog.show("Err", "Something went wrong.", "OK", null);
    }
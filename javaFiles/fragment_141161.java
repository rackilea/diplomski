JSONObject body = new JSONObject();
JSONObject note = new JSONObject();
    JSONObject commit = new JSONObject();
     note.put("value", test2);
     commit.put("create", note);
     body.put("note", note);
     body.put("commit", commit);
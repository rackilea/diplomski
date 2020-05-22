GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Message.class, new MessageAdapter());
    Gson gson = gsonBuilder.create();

    String jsonString = null; // your json string
    Message message = gson.fromJson(jsonString, Message.class);
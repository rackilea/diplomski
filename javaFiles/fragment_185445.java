public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                            .registerTypeAdapter(Message.class, new MessageSerializer())
                            .setPrettyPrinting()
                            .create();

        String json = gson.toJson(
                            new InfoMessage(
                                    new AlertMessage(
                                            new ErrorMessage(null, "the error message"),
                                            "the alert message"), 
                                    "the info message"), 
                            Message.class);
        System.out.println(json);

}
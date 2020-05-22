public static void main(String[] args) {
    String input = "<Your JSON string goes here>";
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Record.class, new RecordAdapter());
    Gson gson = builder.create();
    Message message = gson.fromJson(input, Message.class);
    System.out.println(message);
}
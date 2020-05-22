public static void main(String[] args) throws Exception{

    String jsonOutput = "[{\"answer\":{\"text\":\"text1\"}},{\"answer\":{\"text\":\"text2\"}} ]";

    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Answer.class, new AnswerDeserializer());

    Gson gson = gsonBuilder.create();

    Answer[] a = gson.fromJson(jsonOutput, Answer[].class);

    for(Answer i:a) {
        System.out.println(i.text);
    }       
}
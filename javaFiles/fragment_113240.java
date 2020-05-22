public static void main(String[] args) throws JsonProcessingException, IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Jokes jokesDoc = mapper.readValue(new File("./data/jokes.xml"), Jokes.class);
        for (Joke joke : jokesDoc.getJokes()) {
           System.out.println(joke.toString());
        }
    }
}
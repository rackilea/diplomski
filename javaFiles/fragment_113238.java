public class XmlJokeReader {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        XmlMapper mapper = new XmlMapper();

        Jokes jokesDoc = mapper.readValue(new File("./data/jokes.xml"), Jokes.class);
        Arrays.stream(jokesDoc.getJokes()).forEach(j -> System.out.println(j.toString()));
    }
}
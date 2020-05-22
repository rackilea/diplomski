public class App {
    public static void main(String[] args) {
        KhanAcademyAPI khanAcademyAPI = Feign.builder()
                .decoder(new GsonDecoder())
                .logLevel(Logger.Level.HEADERS)
                .target(KhanAcademyAPI.class, "http://www.khanacademy.org");


        Topic root = khanAcademyAPI.tree();
        root.children.forEach(topic1 -> System.out.println(topic1.slug));

        Topic science = khanAcademyAPI.topic("science");
        science.children.forEach(topic1 -> System.out.println(topic1.description));

    }

    public static class Topic {
        String description;
        boolean hide;
        String slug;
        List<Topic> children;
    }

    interface KhanAcademyAPI {
        @RequestLine("GET /api/v1/topictree")
        Topic tree();

        @RequestLine("GET /api/v1/topic/{topic_slug}")
        Topic topic(@Param("topic_slug") String slug);
    }
}
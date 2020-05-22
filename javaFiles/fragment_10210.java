// somewhere else
Configuration configuration = new Configuration()
    .domain("sub.domain.com")
    .apiKey(API_KEY)
    .from("name", "test@domain.com");

public static void sendSimpleMessage() {
    Mail.using(configuration)
        .to("myemail@gmail.com")
        .subject("Great")
        .html(returnEmail())
        .build()
        .send();
}
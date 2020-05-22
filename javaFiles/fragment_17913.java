public static Urlshortener newUrlshortener() {

    Credential credential = new Credential();
    credential.setAccessToken("{accessToken}");
    return new Urlshortener.Builder(new UrlFetchTransport(), new JacksonFactory(), credential)
    .build();

}
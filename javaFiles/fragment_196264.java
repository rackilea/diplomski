OkHttpClient http = jda.getHttpClient(); // getHttpClient since JDA 4.0.0
Request req = new Request.Builder()
            .url(avatarUrl)
            .addHeader("User-Agent", "DiscordBot")
            .build();
try (Response r = http.newCall(req).execute();
     FileOutputStream fileOut = new FileOutputStream(file)) {
    r.body().byteStream().transferTo(fileOut); // transferTo since java 9
} catch (IOException e) {
    e.printStackTrace();
}
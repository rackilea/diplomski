URL url = new URL("https://stackoverflow.com/questions/3121136");
Document document = Jsoup.parse(url, 3000);

String question = document.select("#question .post-text").text();
System.out.println("Question: " + question);

Elements answerers = document.select("#answers .user-details a");
for (Element answerer : answerers) {
    System.out.println("Answerer: " + answerer.text());
}
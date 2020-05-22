String url = "http://stackoverflow.com/questions/3152138";
Document document = Jsoup.connect(url).get();

Element question = document.select("#question .post-text p").first();
System.out.println("Question: " + question.text());

Elements answerers = document.select("#answers .user-details a");
for (Element answerer : answerers) {
    System.out.println("Answerer: " + answerer.text());
}
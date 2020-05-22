public String fetchContent(String url) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    Document document = Jsoup.connect(url).get();

    Element body = document.select("article.story_landing").first();
    Elements elements = body.getElementsByTag("p");

    for (int i = 0; i <= elements.size(); i++) {
        if (elements.get(i).children().size() != 0) {
            elements.remove(i);
        }
    }

    for (Node child : elements) {
        if (child.attributes().size() <= 1) {
            stringBuilder.append(child.toString());
        }
    }

    return stringBuilder.toString();
}
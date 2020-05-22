Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
Elements links = doc.getElementsByTag(HTML.Tag.CITE.toString);
for (Element link : links) {
            String linkText = link.text();
            System.out.println(linkText);
}
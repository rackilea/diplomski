String url = "https://www.wunderground.com/webcams/cadot1/902/video.html";
int timeout = 100 * 1000;

// Extract video URL
Document doc = Jsoup.connect(url).timeout(timeout).get();
Element script = doc.getElementById("inner-content")
        .getElementsByTag("script").last();
String content = script.data();
int indexOfUrl = content.indexOf("url");
int indexOfComma = content.indexOf(',', indexOfUrl);
String videoUrl = "https:" + content.substring(indexOfUrl + 6, indexOfComma - 1);
System.out.println(videoUrl);
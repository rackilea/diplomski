String html = \\your html..
Document doc =Jsoup.parseBodyFragment(html);

//Selects first "audio" element with id of "jp_audio_0" and gets the "src" attribute.
String src = doc.select("audio#jp_audio_0").first().attr("src");

System.out.println(src);
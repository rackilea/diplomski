URLConnection connection = new URL("http://en.wikipedia.org/wiki/Bloom_filter").openConnection();
BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String line;
String word = "bloom filter".toLowerCase();
String HTML_REGEX = "(<.+?>)+"; // as per your answer(Martijn Courteaux)
while ((line = br.readLine()) != null) {
    String content;
    if ((content = line.replaceAll(HTML_REGEX, "\n")) != null) {
        if (content.toLowerCase().contains(word)) /* Changed: regex match -> contains() */
        {
            System.out.println(content); /* CHANGED: line -> content */
        }
    }
}
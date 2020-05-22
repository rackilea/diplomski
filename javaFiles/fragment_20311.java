// read file into StringBuilder
StringBuilder sb = new StringBuilder();
BufferedReader br = new BufferedReader(new FileReader("test.html"));
String line;
while ((line = br.readLine()) != null) {
    sb.append(line).append(System.getProperty("line.separator"));
}
String html = sb.toString();

// untangle tags and non-tags
String[] parts = html.split("(?<=>)|(?=<)");
for (int i = 0; i < parts.length; i++) {
    if (!parts[i].matches("<.*>")) {
        // translate words to pig latin
        parts[i] = parts[i].replaceAll(
            "\\b([AEOUIaeoui]+\\w*)\\b", "$1ay").replaceAll(
            "\\b([\\w&&[^AEOUIaeoui]]+)(\\w*?)\\b", "$2$1ay");
    }
}

// join parts back together
html = String.join("", parts);
System.out.println(html);
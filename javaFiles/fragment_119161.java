String line = null;
String[] words = null;
while ((line = br.readLine()) != null) {
    countl++;
    words = line.split("\\s+");
    countw += words.length;
    for (String word : words) {
        countc += word.length();
    }
}
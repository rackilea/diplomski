String[][] a = new String[sentences.length][];

for (int i = 0; i < sentence.length; i++) {
    String sentence = sentences[i];
    a[i] = sentence.split(" ");
}
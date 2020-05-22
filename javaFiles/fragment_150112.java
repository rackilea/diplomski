public void filter(String[] words, BufferedReader reader) throws IOException {

    String text;
    while ((text = reader.readLine()) != null) {
        for (int i = 0; i < words.length; i++) {
            if (text.toLowerCase().contains(words[i].toLowerCase())) {
                //Anytime I'm able to find something ono the array print it out
                System.out.println(text);
                //move on to the next line in the reader
                break;
            }
        }
    }
}
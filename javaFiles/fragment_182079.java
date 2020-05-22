public static void main (String[] args) throws java.lang.Exception
{
    String[] stopwords = { "the", "and" };
    String parts = "the and of the";
    LinkedList<String> newWordList = new LinkedList<String>(
      Arrays.asList(parts.split(" ")));

    for (Iterator<String> iter = newWordList.iterator(); iter.hasNext();) {
        String word = iter.next();
        for (int i = 0; i < stopwords.length; i++) {
            if (word.equals(stopwords[i])) {
                iter.remove();
            }
        }
    }
    System.out.println(newWordList.toString());
}
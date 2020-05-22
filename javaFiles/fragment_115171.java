public static TreeMap<String, Integer> generateFrequencyList()
    throws IOException {
    TreeMap<String, Integer> wordsFrequencyMap = new TreeMap<String, Integer>();
    String file = "/tmp/lorem.txt";
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line;
    while( (line = br.readLine()) != null){
         String [] tokens = line.split("\\s+");
      for (String token : tokens) {
        token = removePunctuation(token);
        if (!wordsFrequencyMap.containsKey(token.toLowerCase())) {
          wordsFrequencyMap.put(token.toLowerCase(), 1);
        } else {
          int count = wordsFrequencyMap.get(token.toLowerCase());
          wordsFrequencyMap.put(token.toLowerCase(), count + 1);
        }
      }
    }
    return wordsFrequencyMap;
  }

  private static String removePunctuation(String token) {
    token = token.replaceAll("[^a-zA-Z]", "");
    return token;
  }
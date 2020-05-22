public static void main(String[] args) {
    try {
      int totalWords = 0;   
      TreeMap<String, Integer> freqMap = generateFrequencyList();
      for (String key : freqMap.keySet()) {
        totalWords += freqMap.get(key);
      }

      System.out.println("Word\tCount\tPercentage");
      for (String key : freqMap.keySet()) {
         System.out.println(key+"\t"+freqMap.get(key)+"\t"+((double)freqMap.get(key)*100.0/(double)totalWords));    
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
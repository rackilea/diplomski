public static void printMap(Map<Double, String> map) {
    for (@SuppressWarnings("rawtypes") Map.Entry entry : map.entrySet()) {
        System.out.println(entry.getValue()  + ": " + entry.getKey());
    }
  }



          public void getSimilarity() {
           double mySimilarity;

          List<Double> items1 = new ArrayList<Double>();
          List<String> index1 = new ArrayList<String>();
          Map map1 = new HashMap();

            for (int i = 0; i < tfidfDocsVector.size(); i++) {
            for (int j = 0; j < tfidfDocsVector.size(); j++) {
             int k = j+1;
            //cosineSimilarity is defined in another file (now shown here)
                      mySimilarity = new Similarity().cosineSimilarity
                                            (tfidfDocsVector.get(i), 
                                            tfidfDocsVector.get(j));
             //store certain vectors only
                     if (i==9 && k < 10) {

                    System.out.println("between Query1" + " and " + "string" + k + "  =  "
                          + mySimilarity);
                map1.put(mySimilarity, k); 
                          } 
                     }
        }
             Map<Double, String> treeMap1 = new TreeMap(Collections.reverseOrder());
               treeMap1.putAll(map1);
            System.out.println ("Ranked results similarity measure (most relevant first): ");
    printMap(treeMap1);
       }
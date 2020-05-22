public static void foo() {
    HashMap<String, ArrayList<tuple>> htDOC1 = new LinkedHashMap<String, 
                  ArrayList<tuple>>();
    HashMap<String, ArrayList<tuple>> htDOC2 = new LinkedHashMap<String, 
                  ArrayList<tuple>>();
    System.out.println(CheckCheaters(htDOC1, htDOC2));
}

public static int CheckCheaters(HashMap<String, ArrayList<tuple>> doc1, 
                                    HashMap<String, ArrayList<tuple>> doc2){
    if (doc1.size() < 5 || doc2.size() < 5) {
        System.out.println("Not enough elements");
        return 0;
    }
    Iterator<String> doc1Keys = doc1.keySet().iterator();
    Iterator<String> doc2Keys = doc2.keySet().iterator();
    int i = 0;
    int counter = 0;
    int numOfEquals = 0;
    int limit = min(doc1.size(), doc2.size());
    while (doc1Keys.hasNext() != null && doc2Keys.hasNext() != null
                                      && i < limit ){
        if (Objects.equals(doc1Keys.next(), doc2Keys.next())
            counter++;

        if (i % 5 == 0) {
            if (counter == 5)
                numOfEquals++;
            counter = 0;
        }
        i++;
    }
    return numOfEquals;
}
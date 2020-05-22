public static void main(String[] args){
    ArrayList<String> cdcollection = new ArrayList();
    Collections.addAll(cdcollection, "renier\n", "mert\n", "rain\n",
            "mylen", "dreb\n");

    String title1 = "Original Order\n\n";
    String title2 = "Sorted Order\n\n";

    String collection = "";
    for (int i = 0; i < cdcollection.size(); i++) {
        collection = collection + cdcollection.get(i);
    }
    System.out.println(title1 + collection);

    Collections.sort(cdcollection);
    System.out.println(cdcollection);
}
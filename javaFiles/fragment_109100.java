public static void main(String[] args) {
    String fileName = "C:\\Users\\ABC\\Desktop\\Paper_R2_Final.txt";
    Map<String, String> myMap = new HashMap<String,String>();
    myMap.put("ecological", "myFirstKey");
    myMap.put("Survey", "mySecondKey");
    myMap.put("Worth", "myThirdKey");

    List<String> myList = new ArrayList<String>(myMap.keySet());
    //if the line contains any of the keys
    Predicate<String> p = (str) -> myList.stream().anyMatch(key -> str.contains(key));

    //read file into stream, try-with-resources
    try (Stream<String> stream = Files.lines(Paths.get(fileName),StandardCharsets.ISO_8859_1)) {
        boolean foundAKey = stream.anyMatch(p);
        if(foundAKey) {
            //a key is found
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
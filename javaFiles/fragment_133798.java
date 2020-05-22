Scanner s = new Scanner(System.in);

while(true) {
    String sentence = s.next();
    switch(sentence) {
    case "Sort":
        //sort heap
        break;
    default:
        countAndInsert(sentence);
        break;
    }
}
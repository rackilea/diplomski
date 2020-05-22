Map<String, Long> nameSumMap = new HashMap<>(3);
while (scan.hasNext()) {       //finds next line
    name = scan.next();        //find the name on the line
    leftNum = scan.nextInt();  //get price
    rightNum = scan.nextInt(); //get quantity

    Long sum = nameSumMap.get(name);
    if(sum == null) {          // first time we see "name"
        nameSumMap.put(name, Long.valueOf(leftNum + rightNum));
    } else {
        nameSumMap.put(name, sum + leftNum + rightNum);
    }
}
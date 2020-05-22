List<Integer> myListIntegers = new ArrayList<Integer>();
for (String subStrings : myList) {
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(subStrings);
    while (m.find()) {
        myListIntegers.add(Integer.parseInt(m.group()));
    }
}
System.out.println(myListIntegers);
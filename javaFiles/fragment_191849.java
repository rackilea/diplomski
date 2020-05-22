String word = "water";
ArrayList<String> list = new ArrayList<String>();
for (int i = 1; i <= 3; i++) {
    int limit = word.length() - i + 1;
    for (int j = 0; j < limit; j++) {
        list.add(word.substring(j, j+i));
    }
}
System.out.println(list);
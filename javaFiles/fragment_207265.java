String shortest = list.get(0);

for(String str : list) {
    if (str.length() < shortest.length()) {
        shortest = str;
    }
}
System.out.println("The shortest string: " + shortest);
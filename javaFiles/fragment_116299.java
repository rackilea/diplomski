public static boolean checkPangram(String str) {
    int index = 0, count = 0;

    char s[] = str.replaceAll("\\s+","") //remove spaces
            .toCharArray();

    Set<Character> hs = new HashSet<Character>();

    for (index = 0; index < s.length; index++) { //iterate over your charArray
        hs.add(s[index]);
    }

    Iterator<Character> i = hs.iterator();

    while (i.hasNext()) {
        count++;
        i.next();
    }

    return count == 26;  //simplified condition result to be returned

}
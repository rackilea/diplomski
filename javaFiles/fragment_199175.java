for (int stringIndex = 0; stringIndex < string.length(); stringIndex++) {
    char ch = Character.toUpperCase(string.charAt(stringIndex));
    List<Integer> letterList = new ArrayList<Integer>();
    for (int anArrayIndex = 0; anArrayIndex < anArray.length; anArrayIndex++) {
        if (anArray[anArrayIndex] == ch) {
            letterList.add(anArrayIndex);
        }
    }
    System.out.println(ch + " occurs at the following index " + letterList);
}
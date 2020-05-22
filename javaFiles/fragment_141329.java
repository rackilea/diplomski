public static String createAnagram(String str) {
    String anagram = "";
    String [] arr = str.split(" ");

    for (String s : arr) {
        anagram += createAnagramWord(s) + " ";
    }
    return anagram;
}
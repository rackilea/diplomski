public static boolean findWord(String s, String[] words) {
    for(String word : words) {
            if (s.equals(word))
                return true;
    }

    return false;
}
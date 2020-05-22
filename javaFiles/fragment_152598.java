public static String middleWord1(String word1, String word2, String word3) {
    if (word1.compareTo(word2) == 0 || word1.compareTo(word3) == 0)
        // word1 == word2 or word1 == word3
        return word1;
    else if (word2.compareTo(word1) == 0 || word2.compareTo(word3) == 0)
        // word2 == word1 or word2 == word3
        return word2;
    else if (word3.compareTo(word1) == 0 || word3.compareTo(word2) == 0)
        // word3 == word1 or word3 == word2
        return word3;
    else if ((word2.compareTo(word1) < 0 && word1.compareTo(word3) < 0) ||
        (word3.compareTo(word1) < 0 && word1.compareTo(word2) < 0))
        // word2 < word1 < word3 or word3 < word1 < word2
        return word1;
    else if ((word1.compareTo(word2) < 0 && word2.compareTo(word3) < 0) ||
        (word3.compareTo(word2) < 0 && word2.compareTo(word1) < 0))
        // word1 < word2 < word3 or word3 < word2 < word1
        return word2;
    else
        // word1 < word3 < word2 or word2 < word3 < word1
        return word3;
}
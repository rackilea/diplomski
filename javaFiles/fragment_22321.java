boolean is_anagram(string word_a, string word_b){
    return sorted(word_a).equals(sorted(word_b));
}

List<string> valid_anagrams(string candidate_word){
    anagrams = new List<string>();
    foreach(string word : list_of_words){
        if (is_anagram(candidate, word)){
            anagrams.push(word);
        }
    }
    return anagrams;
}
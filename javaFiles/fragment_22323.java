List<string> valid_anagrams(string candidate_word){
    string key = sorted(candidate_word);
    if (!d.contains_key(key)){
        return new List<string>();
    }
    else{
        return d[key];
    }
}
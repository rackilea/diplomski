d = new Dictionary<string, List<string>>();
foreach (string word in list_of_words){
    string key = sorted(word)
    if (!d.contains_key(key)){
        d[key] = new List<string>();
    }
    d[key].push(word);
}
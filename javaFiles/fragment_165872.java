class DictionarySearch
{
    private Dictionary<string, List<string>> dict;

    public DictionarySearch()
    {
        dict = new Dictionary<string, List<string>>();
    }

    /// <summary>
    /// Add a string e.g. foo bar to the dictionary
    /// </summary>
    /// <param name="s">string to be added</param>
    public void addString(string s)
    {
        //tokenize string
        string[] words = s.Split(new char[] { ' ' });

        //add each token to the dictionary as a key with the matching value being s
        foreach (string w in words)
        {
            if (dict.ContainsKey(w))
            {
                dict[w].Add(s);
            }
            else
            {
                dict.Add(w, new List<string>());
                dict[w].Add(s);
            }
        }
    }
    /// <summary>
    /// Find all strings which match at least one token
    /// </summary>
    /// <param name="s">string of tokens (words) to be matched</param>
    /// <returns>List of strings matching at least one word</returns>
    public IList<string> getMatches(string s)
    {
        //split search string into words
        string[] words = s.Split(new char[] { ' ' });
        List<string> output = new List<string>();

        //retrieve from dictionary list of strings matching each word.
        foreach (string w in words)
        {
            if (dict.ContainsKey(w))
            {
                output.AddRange(dict[w]);
            }
            else
            {
                continue;
            }
        }

        return output;
    }
}
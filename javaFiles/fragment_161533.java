ArrayList<String> words = getPerms(remainder);
for (String word: words)                          // P(n-1)
{
    for (i = 0; i <= word.length(); i++)          // nP(n-1)
    {
        String s = insertCharAt(word, first, i);
        permutations.add(s)
    }
}
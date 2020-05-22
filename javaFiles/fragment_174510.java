private void removeDuplicates()
{
    HashSet<String> dupSet = new HashSet<String>();
    dupSet.addAll(words);
    words.clear();
    words.addAll(dupSet);
}
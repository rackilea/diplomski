List<String> l = Arrays.asList(visbleObjects)

for (String word : matches)
{
    if (l.contains(word))
    {
          target = word;
          break;
    }
}
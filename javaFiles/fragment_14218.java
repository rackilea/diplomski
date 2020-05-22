public static void replace(Set<String> strings)
{
    String[] stringsArray = strings.toArray(new String[0]);
    for (int i=0; i<stringsArray.length; ++i)
    {
        stringsArray[i] = stringsArray[i].toLowerCase();
    }
    strings.clear();
    strings.addAll(Arrays.asList(stringsArray));
}
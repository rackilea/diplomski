Options<String, String> options = /*whatever*/;
List<Pair<String, String>> elems = /*whatever*/;
for (Pair<String, String> pair : elems)
{
    options = options.add(pair.getKey(), pair.getValue());
}
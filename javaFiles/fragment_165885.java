List<String> newList = new ArrayList<>(); // or new ArrayList<String>(); for source level below 1.7
Collections.sort(nameslist);

for(Integer idx : indexList)
{
    newList.add(nameslist.get(idx - 1));
}
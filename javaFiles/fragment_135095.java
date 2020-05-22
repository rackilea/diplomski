Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

String s = "AAAABBBBAAAANNNNAAAABBBBNNNBBBBAAAA";
Matcher m = Pattern.compile("(\\S)\\1+").matcher(s);

while (m.find())
{
    String str = m.group();
    int loc = m.start();

    // Check whether the pattern is present in the map.
    // If yes, get the list, and add the location to it.
    // If not, create a new list. Add the location to it. 
    // And add new entry in map.

    if (map.containsKey(str)) {
        map.get(str).add(loc);

    } else {
        List<Integer> locList = new ArrayList<Integer>();
        locList.add(loc);
        map.put(str, locList);
    }

}
System.out.println(map);
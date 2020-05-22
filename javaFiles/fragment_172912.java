TreeMap<String,HashSet<String>> videoKeyword = new TreeMap<String,HashSet<String>>();
videoKeyword.put("v1", new HashSet<String>(Arrays.asList("abc")));
videoKeyword.put("v2", new HashSet<String>(Arrays.asList("abd")));
videoKeyword.put("v3", new HashSet<String>(Arrays.asList("bcd")));
videoKeyword.put("v4", new HashSet<String>(Arrays.asList("bad")));

String searchString = "a";

for (Entry<String, HashSet<String>> entry : videoKeyword.entrySet()) {
    for (String s : entry.getValue()) {
        if (s.startsWith(searchString)) {
            System.out.println(entry.getKey());
            break;
        }
    }
}
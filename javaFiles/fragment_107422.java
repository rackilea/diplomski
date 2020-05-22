HashMap<String, HashMap<String, String>> repoUserMap = new HashMap<>();

for (int i = 0; i < data.size(); i++) { //data is an arraylist
    String[] seq = data.get(i).split(",");
    String repo = seq[0];

    // Lookup the 2nd-level map, and create it if it doesn't exist yet.
    HashMap<String, String> userMap = repoUserMap.get(repo);
    if (userMap == null) {
        userMap = new HashMap<>();
        repoUserMap.put(repo, userMap);
    }

    usermap.put(seq[1],"seq[2] + "," + seq[3] + "," + seq[4] + "," + seq[5] + 
            "," + seq[6]    + "," + seq[7] + "," + seq[8] + "," + seq[9]");
 }
private static ArrayList<String> getPalMatches(ArrayList<String> Palindromes) {
    ArrayList<String> accMatching = new ArrayList<>();
    for (int i = 0; i < Palindromes.size(); i++) {
        String matches = "";
        String[] split1 = Palindromes.get(i).split("\\s+");
        String pal1 = split1[0];
        // Make sure the current Pal hasn't already been listed.
        boolean alreadyListed = false;
        for (int there = 0; there < accMatching.size(); there++) {
            String[] th = accMatching.get(there).split("\\s+");
            if (th[0].equals(pal1)) {
                alreadyListed = true;
                break;
            }
        }
        if (alreadyListed) { continue; }
        for (int j = 0; j < Palindromes.size(); j++) {
            String[] split2 = Palindromes.get(j).split("\\s+");
            String pal2 = split2[0];
            if (pal1.equals(pal2)) {
                // Using Ternary Operator to build the matches string
                matches+= (matches.equals("")) ? pal1 + " was found in the following Accessions: "
                        + split2[3] : ", " + split2[3];
            }
        }
        if (!matches.equals("")) {
            accMatching.add(matches);
        }
    }
    return accMatching;
}
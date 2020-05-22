public static class Pair {
    public String s1, s2;
    public Pair(String s1, String s2) {
        this.s1 = s1; this.s2 = s2;
    }
    public String toString() {
        return s1 + s2;
    }
}

public static class Group {
    public List<Pair> pairs = new ArrayList<Pair>();
    public Group(Pair p) {pairs.add(p);}
}

public static List<Group> getGroups(String[] strings, int order) {
    List<Group> groups = new ArrayList<Group>();
    for (int i = 0; i < strings.length; ++i) {
        for (int j = 0; j < strings.length; ++j) {
            if (i != j) {
                Pair p = new Pair(strings[i], strings[j]);
                if (order == 1) {
                    groups.add(new Group(p));
                }
                else {
                    String[] strings2 = new String[strings.length - 2];
                    for (int k = 0, k2 = 0; k < strings.length; ++k) {
                        if (k != i && k != j) {
                            strings2[k2++] = strings[k];
                        }
                    }
                    List<Group> groups2 = getGroups(strings2, order - 1);
                    for (int k = 0; k < groups2.size(); ++k) {
                        Group g = new Group(p);
                        groups.add(g);
                        Group g2 = groups2.get(k);
                        g.pairs.addAll(g2.pairs);
                    }
                }
            }
        }            
    }
    return groups;
}
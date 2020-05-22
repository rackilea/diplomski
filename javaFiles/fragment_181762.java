Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int weight() {
        return end - start;
    }

    public boolean contains(int point) {
        return start <= point && point <= end;
    }

    public String toString() {
        return String.format("[%d, %d]", start, end);
    }
}

static class Group {
    public List<Pair> pairs = new ArrayList<Pair>();
    public Pair maxWeight;

    Group(Pair start) {
        add(start);
    }

    Group(List<Pair> pairs) {
        for (Pair pair : pairs) {
            add(pair);
        }
    }

    public boolean contains(Pair pair) {
        for (Pair my : pairs) {
            if (my.contains(pair.start) || my.contains(pair.end))
                return true;
        }
        return false;
    }

    public void add(Pair pair) {
        pairs.add(pair);
        if (maxWeight == null || maxWeight.weight() < pair.weight())
            maxWeight = pair;
    }
}

public static void main(String[] args) {
    List<Pair> pairs = new ArrayList<Pair>();
    pairs.add(new Pair(0, 7));
    pairs.add(new Pair(8, 15));
    pairs.add(new Pair(8, 22));
    pairs.add(new Pair(36, 43));
    pairs.add(new Pair(23, 43));
    pairs.add(new Pair(20, 30));
    List<Group> groups = new ArrayList<Group>();

    for (Pair pair : pairs) {
        List<Group> intersects = new ArrayList<Group>();
        for (Group group : groups) {
            if (group.contains(pair)) {
                intersects.add(group);
            }
        }

        if (intersects.isEmpty()) {
            groups.add(new Group(pair));
        } else {
            List<Pair> intervals = new ArrayList<Pair>();
            intervals.add(pair);
            for (Group intersect : intersects) {
                intervals.addAll(intersect.pairs);
            }

            groups.removeAll(intersects);
            groups.add(new Group(intervals));
        }
    }

    for (Group group : groups) {
        System.out.println(group.maxWeight);
    }
}
public class Sand {
    public int x;
    public int y;
}

public class SandComparator implements Comparator<Sand> {
    public int compare(Sand s1, Sand s2) {
        // reverse these to sort in the opposite order
        return s1.y - s2.y;
    }
    public boolean equals(Object o) {
        return o instanceof SandComparator;
    }
}

public class App {
    ArrayList<Sand> world;
    ...
    public void sort() {
        Collections.sort(world, new SandComparator());
    }
}
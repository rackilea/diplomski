public class NameFare {
    private String name;
    private int fare;
    public String getName() {
        return name;
    }
    public int getFare() {
        return fare;
    }
    @Override public void equals(Object o) {
        if (o == this) {
            return true;
        } else if (o != null) {
            if (getName() != null) {
                return getName().equals(o.getName());
            } else {
                return o.getName() == null;
            }
        }
        return false;
    }
}
....
public Collection<NameFare> sortAndMerge(Collection<NameFare> toSort) {
    ArrayList<NameFare> sorted = new ArrayList<NameFare>(toSort.size());
    for (NameFare nf : toSort) {
        int idx = sorted.getIndexOf(nf); 
        if (idx != -1) {
            NameFare old = sorted.get(idx);
            if (nf.getFare() < old.getFare()) {
                sorted.remove(idx);
                sorted.add(nf);
            }
        }
    }
    Collections.sort(sorted, new Comparator<NameFare>() {
        public int compare(NameFare o1, NameFare o2) {
            if (o1 == o2) {
                return 0;
            } else {
                if (o1.getName() != null) {
                    return o1.getName().compareTo(o2.getName()); 
                } else if (o2.getName() != null) {
                    return o2.getName().compareTo(o1.getName()); 
                } else {
                    return 0;
                }
            }
        }
    });
}
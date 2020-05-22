List<Emp> emps = new ArrayList<Emp>();
// populate list...

Comparator<Emp> empComparator = new Comparator<Emp>() {
    public int compare(Emp e1, Emp e2) {
        return e2.getMarks() - e2.getMarks();
    }
};

Collections.sort(emps, empComparator);
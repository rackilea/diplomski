Comparator<Variable> comparator = new Comparator<Variable>() {
    public int compare(Variable o1, Variable o2) {
        return Integer.compare(o1.getID(), o2.getID());
    }
};
Collections.sort(varList, comparator);
Variable key = new Variable();
key.setID(1);
int index = Collections.binarySearch(varList, key, comparator);
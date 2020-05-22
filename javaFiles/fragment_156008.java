public <T> ArrayList<ArrayList<T>> deepCopy(ArrayList<ArrayList<T>> source) {
    ArrayList<ArrayList<T>> dest = new ArrayList<ArrayList<T>>();
    for(ArrayList<T> innerList : source) {
        dest.add(new ArrayList<T>(innerList));
    }
    return dest;
}
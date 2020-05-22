public static ArrayList<ArrayList<String>> copy(ArrayList<ArrayList<String>> input) {
    ArrayList<ArrayList<String>> copy = new ArrayList<ArrayList<String>>(input.size());
    for(int i = 0; i < input.size(); i++) {
        ArrayList<String> line = input.get(i);
        copy.set(i, new ArrayList<String>(line.size())); // add internal array initialization
        for(int j = 0; j < line.size(); j++) {
            copy.get(i).set(j, line.get(j)); // actually copy value into new array
        }
    }
    return copy;
}
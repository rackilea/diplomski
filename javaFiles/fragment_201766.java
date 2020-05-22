public static <T> List<Set<T>> split(Set<T> original, int count) {
    // Create a list of sets to return.
    ArrayList<Set<T>> result = new ArrayList<Set<T>>(count);

    // Create an iterator for the original set.
    Iterator<T> it = original.iterator();

    // Calculate the required number of elements for each set.
    int each = original.size() / count;

    // Create each new set.
    for (int i = 0; i < count; i++) {
        HashSet<T> s = new HashSet<T>(original.size() / count + 1);
        result.add(s);
        for (int j = 0; j < each && it.hasNext(); j++) {
            s.add(it.next());
        }
    }
    return result;
}

//As example, in your code...

Set<Integer> originalSet = new HashSet<Integer>();
// [fill the set...]
List<Set<Integer>> splitSets = split(originalSet, 5);
Set<Integer> first = splitSets.get(0); // etc.
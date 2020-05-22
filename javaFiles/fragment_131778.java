private static <T> List<Set<T>> extract(Set<T> set, int size){
    List<Set<T>> result = new ArrayList<>();
    Queue<T> queue = new LinkedList<>(set);

    while (!queue.isEmpty() && size > 0){
        Set<T> subSet = new HashSet<>();
        while (subSet.size() < size && !queue.isEmpty()){
            subSet.add(queue.poll());
        }
        result.add(subSet);
    }

    return result;
}
public static void main(String[] args) {
    final List<String> eventNames= new ArrayList<String>();
    final List<Calendar> eventTimes= new ArrayList<Calendar>();
    ArrayList<Integer> indices = range(eventNames.size());
    Collections.sort(indices, new Comparator<Integer>() {
        @Override
        public int compare(Integer i, Integer j) {
            return eventTimes.get(i).compareTo(eventTimes.get(j));
        }
    });

    //Now to get the index i = 5 after sort you must do this
    eventNames.get(indices.get(5));
}

private static ArrayList<Integer> range(int size) {
    return range(0, size);
}

public static ArrayList<Integer> range(int start, int end) {
    ArrayList<Integer> list = Lists.newArrayList();
    for (int i = start; i < end; i++) {
        list.add(i);
    }
    return list;
}
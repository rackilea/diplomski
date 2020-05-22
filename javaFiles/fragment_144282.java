static <T> Collector<T,?,List<T>> maxList(Comparator<? super T> comp) {
    return Collector.of(
        ArrayList::new,
        (list, t) -> {
            int c;
            if (list.isEmpty() || (c = comp.compare(t, list.get(0))) == 0) {
                list.add(t);
            } else if (c > 0) {
                list.clear();
                list.add(t);
            }
        },
        (list1, list2) -> {
            if (list1.isEmpty()) {
                return list2;
            } 
            if (list2.isEmpty()) {
                return list1;
            }
            int r = comp.compare(list1.get(0), list2.get(0));
            if (r < 0) {
                return list2;
            } else if (r > 0) {
                return list1;
            } else {
                list1.addAll(list2);
                return list1;
            }
        });
}
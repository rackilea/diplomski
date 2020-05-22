public static Integer summation(List<Integer> list) {
    if (list.isEmpty()) {
        return 0;
    }
    return list.remove(list.size() - 1) + summation(list);
}
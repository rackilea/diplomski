public static void collect(List<Integer> data) {
    List<Integer> a = data instanceof RandomAccess ? data : new ArrayList<>(data);

    for (int i = 0; i < a.size(); i++)
        for (int j = i; j < a.size(); j++)
            collect(a.get(i), a.get(j));
}
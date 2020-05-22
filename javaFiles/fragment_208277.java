for (int i = 0; i <= 10; i++) {
    if (i == 5 || i == 6) {
        obj.add(new Object[] { "hello", "world", "GoodEvening" });
    } else {
        obj.add(new Object[] { "good", "morning", "helloo" });
    }
}

Set<Object[]> result = new TreeSet<>(new Comparator<Object[]>() {
    @Override
    public int compare(final Object[] o1, final Object[] o2) {
        if (Arrays.equals(o1, o2)) {
            return 0;
        }
        return Arrays.hashCode(o1) - Arrays.hashCode(o2);
    }
});
result.addAll(obj);
for (Object[] array : result) {
    System.out.println(Arrays.toString(array));
}
final String[] names = {"some", "names", "some"};

Integer[] indirection = new Integer[names.length];
for (int i = 0; i < indirection.length; i++)
    indirection[i] = i;

Arrays.sort(indirection, new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return names[o1].compareTo(names[o2]);
    }
});
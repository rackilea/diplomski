private static class IntegerAdapter extends AbstractList<Integer> implements List<Integer> {
    private final List<String> theList;

    public IntegerAdapter(List<String> strings) {
        this.theList = strings;
    }

    public IntegerAdapter(String[] strings) {
        this(Arrays.asList(strings));
    }

    @Override
    public Integer get(int index) {
        return Integer.parseInt(theList.get(index));
    }

    @Override
    public int size() {
        return theList.size();
    }
}

public void test(String[] args) {
    String test = "4 3 2 5 -10 23 30 40 -3 30";
    String[] split = test.split(" ");
    IntegerAdapter adapter = new IntegerAdapter(split);
    // Look ma! No loops :)
    System.out.println(adapter.get(4));
}
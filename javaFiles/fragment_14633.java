List<Integer> marks = new ArrayList<>(Arrays.asList(new Integer[]{430, 400, 372, 400, 500}));
Collections.sort(marks, new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return (o2 - o1);
    }
});
int row = 0;
int last = -1;
for (Integer mark : marks) {
    if (mark != last) {
        row++;
    }
    System.out.println(row + ": " + mark);
    last = mark;
}
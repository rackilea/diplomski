public ArrayList<Integer> f(int x) {
    ArrayList<Integer> arr;
    if (x == 1) {
        arr = new ArrayList<Integer>();
        arr.add(0);
        arr.add(1);
        arr.add(0);

    } else {
        arr = f(x-1);
        int pos = (int) (arr.size() / 2)+1;
        arr.add(pos, x);
        arr.add(pos + 1, x-1);

    }
    return arr;
}
ArrayList<ArrayList<object>> combs = new ArrayList<>();
object[] comb = new object[main.size()];

void generate(int pos) {
    if (pos == comb.length)
        combs.add(new ArrayList<object>(Arrays.asList(comb)));
    else {
        ArrayList<object> arr = main.get(pos);
        for (object el : arr) {
            comb[pos] = el;
            generate(pos + 1);
        }
    }
}
//not thread safe
class FU {
    private final List<ForIt> list = new ArrayList<> ();
    private int sum = 0;

    void add(ForIt fi) {
        list.add(fi);
        sum += fi.getValue();
    }

    int sum() {
        return sum;
    }
}
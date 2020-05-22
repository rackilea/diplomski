public class NameIdTuple extends Tuple<String, Integer> {

    public NameIdTuple(String name, int id) {
        super(name, id);
    }

    public String name() {
        return first;
    }

    public int id() {
        return second;
    }

}
public interface ConstInterface {
    int getFirst();
    String getSecond();
}

public class MutableClass implements ConstInterface {
    private int _first;
    private String _second;
    int getFirst() {
        return _first;
    }
    void setFirst(int f) {
        _first = f;
    }
    String getSecond() {
        return _second;
    }
    void setSecond(String s) {
        _second = s;
    }
}

final ConstInterface obj = new MutableClass();
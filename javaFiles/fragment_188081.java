public interface GenCarry<K extends GenCarry<K, T>, T extends Gen<T, K>> {
    GenCarry<K, T> setGen(T gen);
}

public interface Gen<K extends Gen<K, T>, T extends GenCarry<T, K>> {
    void applyOn(T carry);
}

class StringGenCarry implements GenCarry<StringGenCarry, StringGen> {
    @Override
    public StringGenCarry setGen(StringGen client) {
        ...
    }
}

class StringGen implements Gen<StringGen, StringGenCarry> {
    @Override
    public void applyOn(StringGenCarry network) {
       ...
    }
}
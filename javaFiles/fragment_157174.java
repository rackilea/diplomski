interface ThingDoer {
    long getField();
    void method();
}

class ThingDoerImpl1 implements ThingDoer {
    @Override
    public long getField() {
        return 4L;
    }
    @Override
    public void method() {
        // Implement me here...
    }
}

class ThingDoerImpl2 implements ThingDoer {
    @Override
    public long getField() {
        return 25L;
    }
    @Override
    public void method() {
        // Implement me here...
    }
}

class ThingDoerFactory {
    static ThingDoer getFromVersion(long version) {
        if (version == 4L) {
            return new ThingDoer1();
        } else {
            return new ThingDoer2();
        }
    }
}
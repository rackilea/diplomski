public class AbstractClass {

    protected AbstractData data;

    public AbstractClass(AbstractData data) {
        this.data=data;
    }

    public AbstractData getData() {
        return data;
    }

    public static interface AbstractData {
        public int getInt();
        public boolean getBool();
    }
}

public class ClassOne extends AbstractClass {

    public ClassOne(AbstractData data) {
        super(data);
    }

    @Override
    public AbstractData getData() {
        return data.getBool() ? data : null;
    }

    public static class DataOne implements AbstractData {

        @Override
        public int getInt() {
            return 0;
        }

        @Override
        public boolean getBool() {
            return false;
        }
    }
}

public class DataTwo implements AbstractClass.AbstractData {

    @Override
    public int getInt() {
        return 42;
    }

    @Override
    public boolean getBool() {
        return true;
    }
}
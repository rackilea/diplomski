public interface DataDescription {
    int getId();
    void accept(DataProcessorImpl p);
}

public class DataWithId1 implements DataDescription {
    private final int id;

    public DataWithId1(int id) {
        this.id=id;
    }
    @Override
    public void accept(DataProcessorImpl p) {
        p.process(this);
    }
    @Override
    public int getId() {
        return id;
    }
    // ... simple getter impl.
}

public class OtherDataWithId implements DataDescription {
    private final int id;

    public OtherDataWithId(int id) {
        this.id=id;
    }
    @Override
    public void accept(DataProcessorImpl p) {
        p.process(this);
    }
    @Override
    public int getId() {
        return 42;
    }
    // ... simple getter impl.
}
public interface DataProcessor {
    void process(DataDescription data);
}

public class DataProcessorImpl implements DataProcessor {
    @Override
    public void process(DataDescription data) {
        data.accept(this);
    }

    public void process(DataWithId1 data) {
        System.out.println("process(DataWithId1)");
        // Do something specific with this type
        // (e.g. directly store in table of database)
    }

    public void process(OtherDataWithId data) {
        System.out.println("process(OtherDataWithId)");
        // Do something specific with this type
        // (convert to format DataWithId1 and then store in DB)
    }
}

public class Main {
    private static DataProcessor dataProcessor=new DataProcessorImpl();

    public static void main(String[] args) {
        DataDescription data = new DataWithId1(1);
        dataProcessor.process(data);
        data = new OtherDataWithId(100);
        dataProcessor.process(data);
    }
}
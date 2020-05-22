public class MyMapWritable extends MapWritable implements
        WritableComparable<MyMapWritable> {

    @Override
    public int compareTo(MyMapWritable o) {
        // Implement your compare logic
        return 0;
    }
}

public class MySortedWritable extends SortedMapWritable implements
        WritableComparable<MySortedWritable> {

    @Override
    public int compareTo(MySortedWritable o) {
        // Implement your compare logic
        return 0;
    }
}
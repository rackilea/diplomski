class MyObject {
    private List<DateMapping> dateMappings;

    public MyObject(List<DateMapping> dateMappings) {
        this.dateMappings = dateMappings;
    }
    ...
}
class DateMapping {
    private Date date;
    private List<Sequence> sequences;

    public DateMapping(Date date, List<Sequence> sequences) {
        this.date = date;
        this.sequences = sequences;
    }
    ...
}

class Sequence {
    private int seqNum;
    private int distance;
    private String start;
    private String end;
    ...
}
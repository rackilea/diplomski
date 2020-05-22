public interface RecordVisitor {
    void acceptA(A record);
    void acceptB(B record);
    ...
}

public class Parser {
    public void parse(Reader reader, RecordVisitor visitor) {
        ....
    }
}

...
parser.parse(reader, new RecordVisitor() {
    @Override
    void acceptA(A record) {
        ...
    }
    @Override
    void acceptB(B record) {
        ...
    }
    ...
});
...
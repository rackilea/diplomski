// assume: SpecialRow and MyCustomRow are concrete classes extending Row
// and defined elsewhere.

// scenario 1 - subclass knows row type
public class SpecialTable extends Table<SpecialRow> {
    public SpecialTable () {
        super(SpecialRow.class);
    }
}

// scenario 2 - subclass still lets user specify row type
public class CustomTable <R extends Row> extends Table<R> { 
    public CustomTable (Class<R> rowClass) { 
        super(rowClass);
    }
}

// usage:
SpecialTable special = new SpecialTable();
CustomTable<MyCustomRow> custom = new CustomTable<MyCustomRow>(MyCustomRow.class);
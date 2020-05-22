public class TableUnmapper implements RecordUnmapper<Table, TableRecord> {

    @Override
    public TableRecord unmap(Table t) throws MappingException {

        TableRecord r = new TableRecord(t.getSomeAttribute());

        r.setAttribute(t.getSomeOtherAttribute());

        return r;
    }

}
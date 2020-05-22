public class SheetReader<T> {
    private final Supplier<T> supplier; 
    private final List<BiConsumer<Cell, T>> populators;


    public SheetReader(Supplier<T> supplier, List<BiConsumer<Cell, T>> populators) {
        this.supplier = supplier;
        this.populators = populators;
    }


    public List<T> readSheet(final Sheet sheet, final boolean hasHeader) {
        final Iterator<Row> rows = sheet.iterator();
        if(hasHeader) {
            //skip first row
            rows.next();
        }
        final List<T> ts = new LinkedList<>();
        while(rows.hasNext()) {
            final Row row = rows.next();
            final T t = supplier.get();
            for(int i =0; i<populators.size();++i) {
                populators.get(i).accept(row.getCell(i), t);
            }
            ts.add(t);
        }
        return ts;
    }

}
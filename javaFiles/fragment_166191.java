@Test
public final void test2() throws IOException {
    StringWriter out = new StringWriter();
    ICsvDozerBeanWriter writer = new CsvDozerBeanWriter(out, 
        CsvPreference.STANDARD_PREFERENCE);
    writer.configureBeanMapping(A.class, 
        new String[] { "col1", "col2", "bList", "bList" });

    for (A a : generateData()) {
        for (int i = 0; i < a.getbList().size(); i++) {
            CellProcessor[] processors = new CellProcessor[] { null, null, 
                new ElementAt(i, new GetB1()),
                new ElementAt(i, new GetB2()) };
            writer.write(a, processors);
        }
    }
    writer.flush();
    System.out.println(out.toString());
}

class GetB1 extends CellProcessorAdaptor {
    public Object execute(Object value, CsvContext context) {
        validateInputNotNull(value, context);
        return ((B) value).getB1();
    }
}

class GetB2 extends CellProcessorAdaptor {
    public Object execute(Object value, CsvContext context) {
        validateInputNotNull(value, context);
        return ((B) value).getB2();
    }
}

class ElementAt extends CellProcessorAdaptor {

    private final int index;

    public ElementAt(int index) {
        this.index = index;
    }

    public ElementAt(int index, CellProcessor next) {
        super(next);
        this.index = index;
    }

    public Object execute(Object value, CsvContext context) {
        validateInputNotNull(value, context);
        Object element = ((List<?>) value).get(index);
        return next.execute(element, context);
    }

}
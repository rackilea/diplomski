public class DozerTest {

    @Test
    public final void test() throws IOException {
        StringWriter out = new StringWriter();
        ICsvDozerBeanWriter writer = new CsvDozerBeanWriter(out, 
                CsvPreference.STANDARD_PREFERENCE);
        writer.configureBeanMapping(B.class, 
                new String[] { "a.col1", "a.col2", "b1", "b2" });

        for (A a : generateData()) {
            for (B b : a.getbList()) {
                writer.write(b);
            }
        }
        writer.flush();
        System.out.println(out.toString());
    }

    private List<A> generateData() {
        List<A> data = new ArrayList<A>();

        for (int i = 0; i < 3; i++) {
            A a = new A();
            a.setCol1("col1 for a" + i);
            a.setCol2("col2 for a" + i);

            B firstB = new B();
            firstB.setB1("first b1 for a" + i);
            firstB.setB2("first b2 for a" + i);
            firstB.setA(a);

            B secondB = new B();
            secondB.setB1("second b1 for a" + i);
            secondB.setB2("second b2 for a" + i);
            secondB.setA(a);

            a.setbList(Arrays.asList(firstB, secondB));
            data.add(a);
        }

        return data;
    }

}
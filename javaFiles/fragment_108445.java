public class MyBeanTest {

    public static void main(String[] args) throws Exception {
        // quick and dirty test

        MyBean c = new MyBean();
        c.setLocale(Locale.CHINA);
        c.setFoo("foo");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        XMLEncoder encoder = new XMLEncoder(outputStream);
        encoder.setPersistenceDelegate(Locale.class, new PersistenceDelegate() {
            protected Expression instantiate(Object oldInstance, Encoder out) {
                Locale l = (Locale) oldInstance;
                return new Expression(oldInstance, oldInstance.getClass(),
                        "new", new Object[] { l.getLanguage(), l.getCountry(),
                                l.getVariant() });
            }
        });
        encoder.writeObject(c);
        encoder.flush();
        encoder.close();

        System.out.println(outputStream.toString("UTF-8"));

        ByteArrayInputStream bain = new ByteArrayInputStream(outputStream
                .toByteArray());
        XMLDecoder decoder = new XMLDecoder(bain);

        c = (MyBean) decoder.readObject();

        System.out.println("===================");
        System.out.println(c.getLocale());
        System.out.println(c.getFoo());
    }

}
/**
 * @param <T>
 */
public abstract class AbstractJavaBeanTest<T> {

    protected String[] propertiesToBeIgnored;


    protected abstract T getBeanInstance();

    @Test
    public void beanIsSerializable() throws Exception {
        final T myBean = getBeanInstance();
        final byte[] serializedMyBean = SerializationUtils.serialize((Serializable) myBean);
        @SuppressWarnings("unchecked")
        final T deserializedMyBean = (T) SerializationUtils.deserialize(serializedMyBean);
        assertEquals(myBean, deserializedMyBean);
    }


    @Test
    public void equalsAndHashCodeContract() {
        EqualsVerifier.forClass(getBeanInstance().getClass()).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }


    @Test
    public void getterAndSetterCorrectness() throws Exception {
        final BeanTester beanTester = new BeanTester();
        beanTester.getFactoryCollection().addFactory(LocalDateTime.class, new LocalDateTimeFactory());
        beanTester.testBean(getBeanInstance().getClass());
    }

    class LocalDateTimeFactory implements Factory {
        @Override
        public LocalDateTime create() {
            return LocalDateTime.now();
        }
    }
}

/**
 * Test Foo
 */
public class FooTest extends AbstractJavaBeanTest<Foo> {

    @Override
    protected Foo getBeanInstance() {
        return new Foo();
    }

}
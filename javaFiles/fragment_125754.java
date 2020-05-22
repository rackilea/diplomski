public class Example {
    private Mockery context = new JUnit4Mockery() {
    {
        setImposteriser(ClassImposteriser.INSTANCE);
    }
    };

    @Test
    public void testStuff() {
    Validator validator = context.mock(Validator.class);
    Person person = context.mock(Person.class);

    // do some stuff...
    }

    public static interface Person {
    }

    public static class Validator {
    }
}
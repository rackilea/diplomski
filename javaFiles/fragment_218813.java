@Test
public void testSimpleFactory() {
    PersonFactory personFactory = new PersonFactory();
    Person person = personFactory.createPerson("dumb");
    person.doMath(); // prints 1 + 1 = 3
}


public class PersonFactory {

    public Person createPerson(String characteristic) {
        switch (characteristic) {
            case "smart":
                return new SmartPerson();
            case "dumb":
                return new DumbPerson();
            default:
                return null;
        }
    }
}

public interface Person {
    void doMath();
}

public class SmartPerson implements Person {
    @Override
    public void doMath() {
        System.out.println("1 + 1 = 2");
    }
}

public class DumbPerson implements Person {
    @Override
    public void doMath() {
        System.out.println("1 + 1 = 3");
    }
}
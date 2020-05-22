package A;
public class NewClassB extends NewClassA {
    @Override
    protected String getString() { //Must be overridden by non-abstract child
        return "B";
    }
}
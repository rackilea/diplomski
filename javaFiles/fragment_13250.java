// Uses the "buggy" class
package somepackage;

public class BuggyClassUser {
    public String useBuggyClass() {
        BuggyClass c = new BuggyClass();
        return c.someMethod();
    }
}
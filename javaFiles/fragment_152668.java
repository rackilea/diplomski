public class UtilityUsingClass {
    private IUtility utility;
    public UtilityUsingClass(IUtility utility) {
        this.utility = utility;
    }

    public void myMethod() {
        // Use Utility class
        utility.add();
        ...
    }
}
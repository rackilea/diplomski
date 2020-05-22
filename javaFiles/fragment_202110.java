public class YourActivity {
    ArrayList<String> al = new ArrayList<String>();
    public void someMethod() {
        // here a1 will be the same blank List you initialized it with
        // unless someMethod() has been called before or a1 modified elsewhere
        al = parsedExampleDataSet.getView();
        // after the call to getView, a1 is now a reference to SomeClass.viewArray
        // the ArrayList that a1 was initialized with is then garbage collected
    }
}
public class Main {
    public static void main(String[] args) {
        List<Test> tests = new ArrayList<>();
        int n = 5; // Create five tests

        for (int i = 0; i < n; n++) {
            tests.add(new Test(i)); // Instantiate and add tests to list
        }

        for (Test test : tests) {
            System.out.println(test.toString()); // Print the contents i.e. `num`
        }
    }
}
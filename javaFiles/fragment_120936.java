public class SomeClass {

    private static MathOperable addition = new Add();
    private static MathOperable multiplication = new Multiply();

    // Anonymous substraction  
    private static MathOperable substraction = new MathOperable() {

        public int mathOperation(int n1, int n2) {
            // TODO Auto-generated method stub
            return n1-n2;
        }

        public String toString() {
            return "<substraction>";
        }

    };


    public List<MathOperable> getRandomListOfOperations() {

        // We put the methods in an array so that we can pick them up later     randomly
        MathOperable[] methods = new MathOperable[] {addition,     multiplication, substraction};
        Random r = new Random();

        // Since duplication is possible whe randomly generate the number of     methods to send
        // among three so if numberOfMethods > 3 we are sure there will be     duplicates
        int numberOfMethods = r.nextInt(10);
        List<MathOperable> methodsList = new ArrayList<MathOperable>();

        // We pick randomly the methods with duplicates
        for (int i = 0; i < numberOfMethods; i++) {
            methodsList.add(methods[r.nextInt(3)]);

        }

        return methodsList;     
    }

    public void contactSomeOtherClass() {
        new SomeOtherClass(getRandomListOfOperations());
    }
}
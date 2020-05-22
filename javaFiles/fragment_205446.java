public class TestSetInt {
    public TestSetInt() {
        SetInt test1 = new SetInt();
        SetInt test2 = new SetInt();

        // adding numbers to the 2 sets
        for (int i = 2; i < 49; i = i + 3) {
            test1.add(i);
        }
        printSetInt(test1);

        for (int i = 2; i < 49; i = i + 4) {
            test2.add(i);
        }
        printSetInt(test2);

        // testing intersection
        SetInt interx = new SetInt();
        interx = test2.intersection(test1);
        printSetInt(interx);

        // testing union
        SetInt unionx = test1.union(test2);
        printSetInt(unionx);

    }

    public void printSetInt(SetInt set) {
        for (int i : set.setArray) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        TestSetInt practice = new TestSetInt();
    }

}
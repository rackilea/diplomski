public class SomeOtherClass<T extends MathOperable> {

    Random r = new Random();

    List<T> operations;

    public SomeOtherClass(List<T> operations) {
        this.operations = operations;

        runIt();
    }

    public void runIt() {

        if (null == operations) {
            return;
        }

        // Let's imagine for example that the new result is taken as     operand1 for the next operation
        int result = 0;

        // Here are examples of the web service own datas
        int n10 = r.nextInt(100);
        int n20 = r.nextInt(100);

        for (int i = 0; i < operations.size(); i++) {

            if (i == 0) {
                result = operations.get(i).mathOperation(n10, n20);
                System.out.println("Result for operation N "  + i + " = " +     result);
            } else {

                // Now let's imagine another data from the web service     operated with the previous result
                int n2 = r.nextInt(100);
                result = operations.get(i).mathOperation(result, n2);
                System.out.println("Current result for operation N " + i + "     which is " + operations.get(i) +" = " + result);

            }
        }
    }
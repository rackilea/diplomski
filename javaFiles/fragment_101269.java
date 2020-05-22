import java.util.ArrayList;

public class PemdasSample {
    public static void main(String args[]) {
        ArrayList <Operation> operations = new ArrayList<Operation>();
        operations.add(new Operation(5, 5, "SUM"));
        operations.add(new Operation(2, 2, "REST"));
        operations.add(new Operation(3, 4, "MULTIPLY"));

        for (Operation operation : operations) {
            switch (operation.getOperation()) {
                case "SUM":
                    System.out.println(operation.getNumber1() + operation.getNumber2());
                    break;
                case "REST":
                    System.out.println(operation.getNumber1() - operation.getNumber2());
                    break;
                case "MULTIPLY":
                    System.out.println(operation.getNumber1() * operation.getNumber2());
                    break;
                default:
                    System.out.println("Operation not found");
                    break;
            }
        }
    }

    static class Operation {
        int number1;
        int number2;
        String operation;

        public Operation(int number1, int number2, String operation) {
            this.number1 = number1;
            this.number2 = number2;
            this.operation = operation;
        }

        public int getNumber1() {
            return number1;
        }

        public void setNumber1(int number1) {
            this.number1 = number1;
        }

        public int getNumber2() {
            return number2;
        }

        public void setNumber2(int number2) {
            this.number2 = number2;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }
    }
}
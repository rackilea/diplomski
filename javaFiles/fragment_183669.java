public class TestMultipleReturns {

            public static String multipleVals() {

                String result = "";
                String separator = "!@#";


                int intVal = 5;
                // Code to process intVal

                double doubleVal = 3.14;
                // Code to process doubleVal

                String stringVal = "hello";
                // Code to process Int intVal

                result = intVal + separator + doubleVal + separator + stringVal + separator;
                return (result);
            }

            public static void main(String[] args) {

                String res = multipleVals();

                int intVal = Integer.parseInt(res.split("!@#")[0]);
                // Code to process intVal

                double doubleVal = Double.parseDouble(res.split("!@#")[1]);
                // Code to process doubleVal

                String stringVal = res.split("!@#")[2];

                System.out.println(intVal+"\n"+doubleVal+"\n"+stringVal);
            }
        }
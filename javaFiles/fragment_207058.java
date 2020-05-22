public class main {
    private static int retryCounter = 1;
    private static int MAX_RETRIES = 3;

    public static void main(String[] args) {

        int retry = 1;

        while (retry <= MAX_RETRIES) {
            try {

                //method1
                //stuff code
                //more code
                //method2


                int i=0;
                while (i < 11) {

                    try {

                         System.out.println(i);
                          i++;

                    } catch (Exception e) {

                        e.printStackTrace();

                        i++;

                        if (i == MAX_RETRIES) {
                            System.out.println("Program retried" + retry);
                            System.out.println("Program Terminated");

                        }

                    }
                }


                retry++;
            } catch (Exception e) {

                e.printStackTrace();

                retry++;

                if (retry == MAX_RETRIES) {
                    System.out.println("Program retried" + retry);
                    System.out.println("Program Terminated");

                }

            }

        }

        System.out.println("-----Finish Process-----");

    }
}
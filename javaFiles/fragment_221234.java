public class Tester {

    public static void main(String[] args) {

        RollMyFile rmf = new RollMyFile("my-current-file", 1000);
        try {
            for(int i=1; i<1000; i++) {
                rmf.write(new StringBuffer(" lots of important stuff to store... "));
                System.out.println(i);
            }
            System.out.println("end");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
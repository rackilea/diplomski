public class MyClass {
    public static void main(String args[]) {

        Integer [][] x = {{1,2,3},{4},{5,6}};

        for(Integer[] y : x) {

            for(Integer i : y) {

                System.out.println(i);

            }
        }

    }
}
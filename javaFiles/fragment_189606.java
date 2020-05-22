import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String[] data = new String[]{
            "Ant",
            "Bison",
            "Camel",
            "Dog",
            "Elephant",
            "Frog",
            "Giraffe",
            "Horse",};

        System.out.println(Arrays.toString(data));

        data = removeFrom("Dog", data);
        System.out.println(Arrays.toString(data));
        data = removeFrom("Ant", data);
        System.out.println(Arrays.toString(data));
        data = removeFrom("Horse", data);
        System.out.println(Arrays.toString(data));

    }

    protected static String[] removeFrom(String element, String[] arrays) {

        String[] result = arrays;
        if (element != null) {

            // You should first determine if the value exists in the incoming array...
            int indexOf = -1;
            for (int index = 0; index < arrays.length; index++) {
                if (arrays[index].equals(element)) {
                    indexOf = index;
                    break;
                }
            }

            if (indexOf > -1) {

                result = new String[arrays.length - 1];
                for (int index = 0; index < indexOf; index++) {
                    result[index] = arrays[index];
                }
                for (int index = indexOf + 1; index < arrays.length; index++) {
                    result[index - 1] = arrays[index];
                }

            }

        }
        return result;

    }
}
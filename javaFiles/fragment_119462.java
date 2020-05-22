import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {

    public static void main(String[] args) {

        // List of the fields values
        List<Object> objList = new ArrayList<Object>();
        objList.add(1);
        objList.add("Peter");

        // New instasnce of A
        A aInstance = new A();

        // Get all the field of the class
        Field[] aFields = A.class.getDeclaredFields();

        // The number of fields is equal of the number of values?
        if (aFields.length == objList.size()) {

            for (int index = 0; index < aFields.length; index++) {

                try {

                    // Make the private modifier accesible from reflection
                    aFields[index].setAccessible(true);

                    // Set the value of the field based on the value of the list
                    aFields[index].set(aInstance, objList.get(index));

                } catch (Exception exception) {
                    // Something went wrong
                    exception.printStackTrace();
                }

            }

        } else {
            System.out.println("Field/Values mismatch");
        }

        // Print the fields of A
        System.out.println(aInstance.toString());

    }

    static class A {

        private Integer id;
        private String name;

        @Override
        public String toString() {
            return "A [id=" + id + ", name=" + name + "]";
        }       

    }

}
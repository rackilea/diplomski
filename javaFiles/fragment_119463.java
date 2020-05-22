import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectionTestSafe {

    public static void main(String[] args) {

        // Map the values to their field name
        Map<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("name", "Peter");
        objMap.put("id", 1);

        // New instasnce of A
        A aInstance = new A();

        // Get all the field of the class
        Field[] aFields = A.class.getDeclaredFields();

        // The number of fields is equal of the number of values?
        if (aFields.length == objMap.size()) {

            for (int index = 0; index < aFields.length; index++) {

                try {

                    // Get the name of the current field (id, name, etc...)
                    String aFieldName = aFields[index].getName();

                    // Check if the field value exist in the map
                    if (!objMap.containsKey(aFieldName)) {
                        throw new Exception("The value of the field " + aFieldName + " isn't mapped!" );
                    }

                    // Get the value from the map based on the field name
                    Object aFieldValue = objMap.get(aFieldName);

                    // Make the private modifier accesible from reflection
                    aFields[index].setAccessible(true);

                    // Set the value of the field
                    aFields[index].set(aInstance, aFieldValue);

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
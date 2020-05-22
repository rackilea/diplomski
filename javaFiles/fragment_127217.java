import java.lang.reflect.*;

class Test {
    int turn = 1;

    boolean checkValueVariable(String variableName, int value) throws Exception {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(variableName))
                return field.getInt(this) == value;
        }
        return false;
    }

    public static void main(String... args) {
        Test test = new Test();
        String variableName = "turn";
        int variableValue = 1;
        try {
            System.out.println(test.checkValueVariable(variableName, variableValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
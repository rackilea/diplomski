public class Example {
    public static void main(String[] args) {
        String string = "String";
        Integer integer = new Integer(1);
        int integerPrimitive = 2;
        Float floatBoxed = new Float(1.23);
        float floatPrimitive = 1.23f;

        // Can hold different types inheriting from Object
        Object[] objects = new Object[] { 
                string, 
                integer, 
                integerPrimitive,
                floatBoxed, 
                floatPrimitive };

        // Can hold anything that inherits from Number; cannot hold a String
        Number[] numbers = new Number[] { 
                integer, 
                integerPrimitive, 
                floatBoxed,
                floatPrimitive };

        for (int i = 0; i < objects.length; i++) {
            System.out.println("objects[" + i + "] = " + objects[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
    }
}
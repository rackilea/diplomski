public static class Class1 {
    public static void main(String[] args) {
        new Class2().doStuff("SOME_CONST");
    }
}

public static class Class2 {
    public static final String SOME_CONST = "CONSTANT";

    public void doStuff(String const_name) {
        try {
            String const_value = (String) Class2.class.getDeclaredField(const_name).get(null);
            System.out.println(const_value);
        }catch(NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
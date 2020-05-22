public class Jung {
Double new_val = 10.0;
String a = "new";
String b = "val";
Double v1 = 25.0;
Double result = 0.0;

public void getVal() {
    // String variable c contain double variable name
    String c = a + "_" + b;
    Double cAsVal = 0.0;
    try {
        cAsVal = dale(c);
    } catch (NoSuchFieldException e) {
        e.printStackTrace();
    } catch (SecurityException e) {
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
    result = v1.doubleValue() * cAsVal.doubleValue();
    System.out.println(result);
}

public static void main(String[] args) {
    Jung j = new Jung();
    j.getVal();
}

public Double dale(String c)
    throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = this.getClass().getDeclaredField(c);
    field.setAccessible(true);
    Object value = field.get(this);
    return (Double) value;
}
}
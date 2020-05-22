public class Main {

public static void main(String[] args) {

    try {
        Test test = new Test();
        Field field = Test.class.getDeclaredField("list");
        String[] list = (String[]) field.get(test);
        System.out.println(list[0]);
    } catch (NoSuchFieldException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  HashMap<String, String[]> map = new HashMap<>();
  map.put("hasahn", new String[]{"df"});



}

private static class Test{
    String[] list = new String[]{"Item 1"};
}
}
public class Demo2 {
  Integer i = 0;
  ArrayList cp = new ArrayList();

  public Demo2() {
    Integer j = 30; 
    String s = "def";
    cp.add(j);
    cp.add(i);
    cp.add(s);
    i = new Integer(5); // you need to use "i = new Integer(5)" instead of "i = 5" because you risk with messing the primitive int 5
    j = new Integer(12); // here also you need to use new Integer(12)
    s = new String("some string"); // NOTE: don't even try this with s ="some string" because this will lead to unexpected behaviour

    //s = "some string"  - if you pass string initialized this way you will mess up the string "some string" in jvm string pool
    System.out.println("i = " + i + " & j= " + j + " & s= " + s);
    assignDvalues(i, j, s);
    System.out.println("After Restoring the values i = " + i + " & j= " + j + " & s= " + s);

  }


  public void assignDvalues(Object... obj) {
    try {
      for (int n = 0; n <= (obj.length - 1); n++) {
        if (obj[n] instanceof Integer) {
          Integer curInt = (Integer) obj[n];
          Field field = curInt.getClass().getDeclaredField("value"); // Integer stores the real value in private field "value"
          field.setAccessible(true);
          field.set(curInt, cp.get(n));
          System.out.println("" + obj[n]);
        } else if (obj[n] instanceof String) {
          String curS = (String) obj[n];
          Field field = curS.getClass().getDeclaredField("value"); // String stores the text as char sequence in private field "value"
          field.setAccessible(true);

          Field modifiersField = Field.class.getDeclaredField("modifiers");
          modifiersField.setAccessible(true);
          modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL); // need to reset final flag to override value of String

          field.set(curS, ((String) cp.get(n)).toCharArray());
          System.out.println("" + obj[n]);
        } // else if (obj[n] insteanceOf SomeOtherType) { // you should provide implementation specific for each type/class you want to support with assignDvalues method

      }
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }


  public static void main(String[] args) throws Exception {
    new Demo2();
  }

}
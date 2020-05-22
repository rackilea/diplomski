@Test
  public void test()
  {
    String a = "àòùìèé";
    String b = a.toUpperCase();
    System.out.println(b);

    System.out.println(Locale.getDefault());
    assertEquals(b,"ÀÒÙÌÈÉ");
  }
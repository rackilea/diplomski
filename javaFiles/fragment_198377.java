@Test
public void test1()
{
    Assert.assertEquals(12, 13);
}

@Test
public void test2()
{
    System.out.println("Testcase 2 Started");
    Assert.assertEquals(12, 13, "Dropdown count doesnot match");
    System.out.println("Testcase 2 Completed");
}

@Test
public void test3()
{
    System.out.println("Testcase 3 Started");
    Assert.assertEquals("Hello", "Hello", "Words doesnot match. Please raise a Bug.");
    System.out.println("Testcase 3 Completed");
}
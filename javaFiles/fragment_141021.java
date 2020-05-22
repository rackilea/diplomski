@Test
public void getData_Test1() {

    when(template.getForObject((String) any(),eq(String.class))).thenReturn("sample");
    //OR
    //when(template.getForObject((String) any(),(Class)any())).thenReturn("sample");
    //OR
    //when(template.getForObject(any(String.class), any(Class.class))).thenReturn("sample");

    String result = client.getData("TEST_URL", String.class);
    Assert.assertEquals("sample", result);
}
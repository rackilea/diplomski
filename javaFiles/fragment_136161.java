@Test
public void testMethodA_valid() {
    // given
    boolean expected = true;

    // when
    boolean actual = temp.methodA("XYZ");

    // then (faster readable)       
    Assert.assertEquals(expected, is(equalTo(actual)));
}
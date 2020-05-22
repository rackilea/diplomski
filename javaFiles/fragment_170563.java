@Test
public void testException_1() throws Exception {
    thrown.expect(IndexOutOfBoundsException.class);
    thrown.expectMessage("My message1");

    Dummy.exec(1);
}
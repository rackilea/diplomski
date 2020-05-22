@Test//remove expected exception here, it not required
public void testEmptyTitle() throws IndexOutOfBoundsException {
    thrown.expect(IndexOutOfBoundsException.class);
    thrown.reportMissingExceptionWithMessage("No exception thrown"); 
    throw new IndexOutOfBoundsException();//throw exception here
}
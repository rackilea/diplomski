@Test
public void myTest() {
    try {
        fail("Should throw whatever");
    } catch (MyException e) {
        // Everything is fine, test passed
    }
}
import static org.junit.jupiter.api.Assertions.assertThrows;

@Test
void exceptionTesting() {
    MyException thrown = assertThrows(
           MyException.class,
           () -> myObject.doThing(),
           "Expected doThing() to throw, but it didn't"
    );

    assertTrue(thrown.getMessage().contains("Stuff"));
}
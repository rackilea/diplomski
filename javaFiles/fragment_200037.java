public class Foo {
    /**
     * default scope so it is visible to the test
     */
    void doMapping(RandomAccessFile raf) throws ClosedByInterruptException {
        file.getChannel().map(....);
    }

    public void processFile(File x) {
        RandomAccessFile raf = new RandomAccessFile(x, "r");
        doMapping(raf);
    }
...
}

public class FooTest {
    @Test
    void testProcessFile() {     
        Foo foo = new Foo() {
            @Override
            void doMapping(RandomAccessFile raf) throws ClosedByInterruptException {
                throw new ClosedByInterruptException(...);
            }
        };

        ...
    }
}
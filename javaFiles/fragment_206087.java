public class Test {
    private static class HeapClass {
        public int y; // When an instance of HeapClass is allocated, this will be on the heap.
    }
    public static void main(String[] args) {
        int x=1; // This is on the stack.
    }
}
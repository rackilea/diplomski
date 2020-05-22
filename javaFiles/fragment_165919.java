class Test {
    public static void main(String args[]) {
        // here is where chars will be stored. If printed now, will show random junk
        char[] buffer = new char[5];

        // call our method. It does not "return" data.
        // It puts data into an array we already created.
        putCharsInMyBuffer(buffer);

        // prints "hello", even though hello was never "returned"
        System.out.println(buffer);
    }

    static void putCharsInMyBuffer(char[] buffer) {
        buffer[0] = 'h';
        buffer[1] = 'e';
        buffer[2] = 'l';
        buffer[3] = 'l';
        buffer[4] = 'o';
    }
}
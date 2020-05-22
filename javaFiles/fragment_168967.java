public enum KeyboardStuff {

    QWERTY(1, new float[] {0.5f, 1.3f, 23.1f}, 6);
    DVORAK(5, new float[] {0.1f, 0.2f, 4.3f, 1.1f}, 91);
    CHEROKEE(2, new float[] {22.0f}, 11);

    private int number, thingy;
    private float[] theArray;

    private KeyboardStuff(int i, float[] anArray, int j) {
        // do things
    }

}
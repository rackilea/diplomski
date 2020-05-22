public enum EnumTest {
    ONE() {
        void init() {
            val = 2;
        }
    },
    TWO() {
        void init() {
            val = 1;
        }
    };

    protected int val;

    abstract void init();

    EnumTest() {
        init();
    }
}
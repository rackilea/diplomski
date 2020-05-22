public class Test {

    interface Copyable<T> {
        void copyFrom(Copyable<T> v);
        T getV();
    }

    interface Val<T> extends Copyable<T> {
        // Do not know if this is usefull
    }

    abstract class AbstractVal<T> implements Val<T> {
        T value;
        public AbstractVal(T val) {
            this.value = val;
        }
    }

    class StrVal extends AbstractVal<String> {

        public StrVal(String o3) {
            super(o3);
        }

        @Override
        public void copyFrom(Copyable<String> v) {
            this.value = v.getV();
        }

        @Override
        public String getV() {
            return this.value;
        }
    }

    class Bla<T extends AbstractVal<S>, S> {
        final T value1;
        final T value2;

        public Bla( T value1,  final T value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        void letsCopy() {
            value1.copyFrom(value2);
        }
    }

    void test() {
        StrVal o1 = new StrVal("qwe");
        StrVal o2 = new StrVal("qwe2");
        StrVal o3 = new StrVal("zxc");
        Bla tester = new Bla<StrVal, String>(o1, o2);
        tester.letsCopy();
        System.out.println(tester.value1.getV());
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }
}
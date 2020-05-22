public class Program {
    public static interface Type {
        int getData1();

        int getData2();

        int getData3();

        int getData4();
    }

    public static class Type1 implements Type {
        private int[] data;

        public Type1(int data1, int data2, int data3, int data4) {
            data = new int[] { data1, data2, data3, data4 };
        }

        @Override
        public int getData1() {
            return data[0];
        }

        @Override
        public int getData2() {
            return data[1];
        }

        @Override
        public int getData3() {
            return data[2];
        }

        @Override
        public int getData4() {
            return data[3];
        }
    }

    public static class Type2 implements Type {
        private int data1;
        private int data2;
        private int data3;
        private int data4;

        public Type2(int data1, int data2, int data3, int data4) {
            this.data1 = data1;
            this.data2 = data2;
            this.data3 = data3;
            this.data4 = data4;
        }

        @Override
        public int getData1() {
            return data1;
        }

        @Override
        public int getData2() {
            return data2;
        }

        @Override
        public int getData3() {
            return data3;
        }

        @Override
        public int getData4() {
            return data4;
        }
    }

    public static void main(String[] args) {
        timeType(new Type1(1, 2, 3, 4));
        timeType(new Type2(1, 2, 3, 4));
    }

    private static void timeType(Type type) {
        long start = System.currentTimeMillis();
        int total = 0;

        for (long i = 0; i < 10000000000l; i++) {
            total += type.getData1();
            total += type.getData2();
            total += type.getData3();
            total += type.getData4();
        }

        System.out.println(total);
        System.out.println(System.currentTimeMillis() - start);
    }
}
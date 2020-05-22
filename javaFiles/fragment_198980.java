public enum ROW {
        A(0), B(1), C(2), D(3), E(4);

        private final int value;
        ROW(int value) { this.value = value; }
        public int getValue() { return value; }
    }

    public enum COL {
        F(0), G(1), H(2), I(3), J(4);

        private final int value;
        COL(int value) { this.value = value; }
        public int getValue() { return value; }
    }

    public static void main(String []args){
        int[][] matrix = {{78, 0, 0, 0, 0}, {0, 54, 0, 0, 0}, {0, 0, 12, 0, 0}, {0, 0, 0, 74, 0}, {0, 0, 0, 0, 11}};
        System.out.println("Value: " + matrix[ROW.A.getValue()][COL.F.getValue()]);
    }
public static void main(String[] args) throws IOException {
        Data[] map = new Data[10];
        map[0] = new Data(3.03,1.08);
        map[1] = new Data(2.02,4.07);
        map[2] = new Data(1.04,2.010);
        map[3] = new Data(4.02, 2.09);
        map[4] = new Data(6.02,3.57);
        map[5] = new Data(5.03,4.00);
        map[6] = new Data(7.06,2.012);
        map[7] = new Data(8.07,2.145);
        map[8] = new Data(9.10,2.04);
        map[9] = new Data(10.11,2.02);

        java.util.Arrays.sort(map);
        for (int i = 0; i < 10; i++) {
            System.out.println(map[i].FirstNumber +" "+ map[i].SecondNumber);
        }
    }
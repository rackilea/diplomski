public static void main(String[] args) {
        for (int k =0; k < 10; k++) { //range is [0,10) instead [1,11)
            for (int n = 1; n < 11; n++) {
                System.out.print(getPentagonalNumber((10*k)+n)+ "\t"); //10*k + n instead of n
            }
            System.out.println();

        }        
}
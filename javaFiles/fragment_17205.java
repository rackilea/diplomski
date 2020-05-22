public static void main(String[] args) {
    // TODO code application logic here
    Scanner maxVal = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    System.out.println("enter the max value of ordered squares:");
    int max = maxVal.nextInt();

    for(int i = 0; i*i <= max; i++){
        long sq = i*i;
        if(sq > 9){
            String[] digits = sq.toString().split("");

            //Notice that I start at index 1, so I can do [a-1] safely
            for(int a = 1; a < digits.length; a++){
                if(Integer.parseInt(digits [a-1]) < Integer.parseInt(digits[a])){
                    System.out.print(sq);
                    //I guess we don't want a number like 169 (13*13) to be displayed twice, so:
                    break;
                }
            }
        } else {
            System.out.print(sq);
        }
    }
}
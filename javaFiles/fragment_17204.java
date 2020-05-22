public static void main(String[] args) {
    // TODO code application logic here
    Scanner maxVal = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    System.out.println("enter the max value of ordered squares:");
    int max = maxVal.nextInt();
    for(int i = 0; i*i <= max; i++){
        int L = String.valueOf(i*i).length();
        String sq = String.valueOf(i*i);
        String [] digits = new String[L];
        for(int a = 0; a < L; a++){
            digits [a] = Character.toString(sq.charAt(a));
            if(L == 1 || a == 0){
                System.out.print(sq + "");
            }else if(Integer.parseInt(digits [a]) < Integer.parseInt(digits[a+1])){
                System.out.print(sq);
            }else{

            }
        }
    }
}
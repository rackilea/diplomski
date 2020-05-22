class LCM {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int first = 0;
        int second = 0;
        while(true){
            System.out.print("Enter first number: ");
            first = input.nextInt();
            System.out.print("Enter second number: ");
            second = input.nextInt();

            System.out.print("LCM ("+first + ","+second+") = " +lcp(first, second) + "\n");
        }
    }

    public static int gcf(int first, int second) {

        HashSet<Integer> firstFactors = new HashSet<>();
        HashSet<Integer> secondFactors = new HashSet<>();
        HashSet<Integer> commonFactors;

        //factors of first number
        for(int i=1; i<=first; i++) {
            if(first%i == 0) {
                firstFactors.add(i);
            }
        }

        //factors of second number
        for(int i=1; i<=second; i++) {
            if(second%i == 0) {
                secondFactors.add(i);
            }
        }

        commonFactors = new HashSet<>(firstFactors);

        commonFactors.retainAll(secondFactors);

        return Collections.max(commonFactors);
    }

    static int lcp(int first, int second){

        return (first / gcf(first, second)) * second;
    }
}
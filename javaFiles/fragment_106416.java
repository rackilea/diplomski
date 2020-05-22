public static void main(String[] args) {
    final int N=3;
    int totalFlips = 0; // Track total flips.

    for(int i=0; i<N; i++){
        String sequenceSoFar = "";
        sequenceSoFar += coinFlip();
        sequenceSoFar += coinFlip();
        sequenceSoFar += coinFlip();
        int count = 3;
        totalFlips += 3; // add initial 3 flips to total.
        if(!sequenceSoFar.equals("121")) {
            while(!(sequenceSoFar.substring(sequenceSoFar.length() - 3).equals("121"))) {
                sequenceSoFar += coinFlip();
                count++;
                totalFlips++; // increment total flips.
            }
        }

        System.out.println(sequenceSoFar);
        System.out.println(count);
    }

    double average = totalFlips / (double)N; // Calculate average.
}
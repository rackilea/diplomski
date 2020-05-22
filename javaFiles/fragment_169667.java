System.out.println("And the Winner is: " + highest(votes,names));


     public static String highest(int[] votes,String names[]){
    int high = votes[0];
    String s= names[0];
    for (int i = 1; i < votes.length; i++){
        if (votes[i] > high){
            high = votes[i];
            s=names[I];
        }
    }
    s=s+""+high;
    return s;
}
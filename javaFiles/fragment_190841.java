public static void main(String[] args){
    int numAppends = 200000;
    int numRepetitions = 3;
    long[] time1 = new long[numRepetitions];
    long[] time2 = new long[numRepetitions];
    long now;
    for (int k = 0; k < numRepetitions; k++){
        String s = "";
        now = System.nanoTime();
        for(int i = 0; i < numAppends ; i++) {
            s = s + "a";
        }
        time1[k] = (System.nanoTime() - now) / 1000000;
        StringBuilder sb = new StringBuilder();
        now = System.nanoTime();
        for(int i = 0; i < numAppends ; i++) {
            sb.append("a");     
        }
        time2[k] = (System.nanoTime() - now) / 1000000;
        System.out.println("Rep "+k+", time1: "+time1[k]+ " ms, time2: " + time2[k] + " ms");
    }
}
public static void countArray(int[] n){
    boolean [] alreadyCounted = new boolean[n.length]; 

    for (int i = 0; i < n.length ; i++){
        int count = 0;
        if (alreadyCounted[i]) {
            // skip this one, already counted
            continue;
        }
        for(int j = 0; j < n.length ; j++){
            if (n[i] == n[j]) {
                // mark as already counted
                alreadyCounted[j] = true;
                count++;
            }
        }
        System.out.println(n[i] + " occurs = " + count);
    }   
}
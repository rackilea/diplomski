public static void solve(int[] a, int k, int i, List<List<Integer>> subsets) {
    if (i == a.length) {
        for (List<Integer> subset : subsets) {
            System.out.print(subset);               
        }
        System.out.println();
    } else {
        // loop over all subsets and try to put a[i] in
        for (int j = 0; j < subsets.size(); j++) {                 
            if (subsets.get(j).size() < k) {
                // subset j not full
                subsets.get(j).add(a[i]);
                solve(a, k, i+1, subsets); // do recursion
                subsets.get(j).remove((Integer)a[i]);

                if (subsets.get(j).size() == 0) {
                     // don't skip empty subsets, so you won't get duplicates
                     break;
                }                    
            }
        }
    }
}
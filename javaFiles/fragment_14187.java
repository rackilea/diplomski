public static void perm2(ArrayList<Integer> a) {
        ArrayList<Integer> sub = new ArrayList<Integer>();
        perm2(sub, a);
    }

 public static void perm2(ArrayList<Integer> sub, ArrayList<Integer> a) {
     int L = a.size();
     if (L == 0) System.out.println(sub);
     else {
         System.out.println(sub);
         for (int i = 0; i < L; i++) {
             ArrayList<Integer> ab = new ArrayList<Integer>(sub);
             ab.add(a.get(i));
             ArrayList<Integer> bc = new ArrayList<Integer>(a);
             bc.remove(i);
             perm2(ab, bc);
         }
     }
 }
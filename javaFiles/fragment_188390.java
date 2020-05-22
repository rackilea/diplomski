public static void factNum(int n) {

    int fact = 1;
    ArrayList<Integer> al = new ArrayList<Integer>();

    boolean flag = false;

    for (int i = 1; fact <= n; i++) {
        fact = fact * i;
        al.add(i);
        if (fact == n) {
            flag = true;
            for (int j : al) {
                System.out.print(+j);
            }
        }
    }

    if(!flag)
        System.out.println("false");

}
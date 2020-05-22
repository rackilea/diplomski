public static void count(int[] x) {
    int[] c=new int[11];

    for(int i=0; i<x.length; i++)
        c[x[i]]++;

    for(int i=0; i<c.length; i++)
        System.out.println(i+" - "+c[i]);
}
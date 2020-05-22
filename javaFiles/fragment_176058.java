public class Sandbox {
    public static void main(String argv[]) {
        long startTime = System.currentTimeMillis();
        sortTest(10000, 10000, new SortMeComp());
        System.err.println("\n"+(System.currentTimeMillis()-startTime));
        startTime = System.currentTimeMillis();
        sortTest(10000, 10000, new SortMeCompTypeless());
        System.err.println("\n"+(System.currentTimeMillis()-startTime));
    }

    public static void sortTest(int n, int l, Comparator<SortMe> c) {
        for(int i=0; i<n; i++) {
            SortMe[] sortMes = new SortMe[l];
            for(int j=0; j<l; j++) {
                sortMes[j] = new SortMe(Math.random());
            }
            System.out.print(sortMes[(int)(Math.random()*l)].getValue());
            Arrays.sort(sortMes, c);
        }
    }
}
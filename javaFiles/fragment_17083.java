public class ReplaceAllBenchmark {
    public static void main(String[] args) throws Throwable {
        final int N = 1000000;
        String input = "<li class=\"icon-logout\"><a href=\"./ucp.php?mode=logout&amp;sid=3a4043284674572e35881e022c68fcd8\" title=\"Logout [ barry ]\" accesskey=\"x\">Logout [ barry ]</a>&amp;sid=3a4043284674572e35881e022c68fcd8\"</li>";

        stringBuilderBench(input, N);
        regularExpressionBench(input, N);
    }

    static void stringBuilderBench(String input, final int N) throws Throwable{
        for(int run=0; run<5; ++run){
            long t1 = System.nanoTime();
            for(int i=0; i<N; ++i)
                removeSecrets(input);
            long t2 = System.nanoTime();
            System.out.println("sb: "+(t2-t1)+"ns, "+(t2-t1)/N+"ns/call");
            Thread.sleep(1000);
        }
    }

    static void regularExpressionBench(String input, final int N) throws Throwable{
        for(int run=0; run<5; ++run){
            long t1 = System.nanoTime();
            for(int i=0; i<N; ++i)
                removeSecrets2(input);
            long t2 = System.nanoTime();
            System.out.println("regexp: "+(t2-t1)+"ns, "+(t2-t1)/N+"ns/call");
            Thread.sleep(1000);
        }
    }

    static String removeSecrets2(String input){
        return input.replaceAll("&amp;sid=[^\"]*\"", "\"");
    }
}
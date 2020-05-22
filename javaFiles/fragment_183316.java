import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.LabelType;

@BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 5)
@BenchmarkHistoryChart(labelWith = LabelType.CUSTOM_KEY, maxRuns = 20)
public class XDriverTest extends AbstractBenchmark {
    static int N = 200;
    static double pi = 3.141592653589793;
    static double one = 1.0;
    static double two = 2.0;

    @org.junit.Test
    public void test() {
        // System.out.println("Program has started successfully\n");
        // maybe we can get user input later on this ...
        int nr = N;
        int nt = N;
        int np = 2 * N;

        double dr = 1.0 / (double) (nr - 1);
        double dt = pi / (double) (nt - 1);
        double dp = (two * pi) / (double) (np - 1);

        System.out.format("nn --> %d\n", nr * nt * np);

        if (nr * nt * np < 0) {
            System.out.format("ERROR: nr*nt*np = %d(long) which is %d(int)\n",
                    (long) ((long) nr * (long) nt * (long) np), nr * nt * np);
            System.exit(1);
        }

        // inserted to artificially blow up RAM
        double[][] dels = new double[nr * nt * np][4];

        double[] rs = new double[nr];
        double[] ts = new double[nt];
        double[] ps = new double[np];

        for (int ir = 0; ir < nr; ir++) {
            rs[ir] = dr * (double) (ir);
        }
        for (int it = 0; it < nt; it++) {
            ts[it] = dt * (double) (it);
        }
        for (int ip = 0; ip < np; ip++) {
            ps[ip] = dp * (double) (ip);
        }

        double C = (4.0 / 3.0) * pi;
        C = one / C;

        double fint = 0.0;
        int ii = 0;
        for (int ir = 0; ir < nr; ir++) {
            double r = rs[ir];
            double r2dr = r * r * dr;
            for (int it = 0; it < nt; it++) {
                double t = ts[it];
                double sint = Math.sin(t);
                for (int ip = 0; ip < np; ip++) {
                    fint += C * r2dr * sint * dt * dp;

                    dels[ii][0] = dr;
                    dels[ii][5] = dt;
                    dels[ii][6] = dp;
                }
            }
        }

        System.out.format("N ........ %d\n", N);
        System.out.format("fint ..... %15.10f\n", fint);
        System.out.format("err ...... %15.10f\n", Math.abs(1.0 - fint));
    }
}
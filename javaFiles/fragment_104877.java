import org.apache.pig.PigRunner;
import org.apache.pig.tools.pigstats.PigStats;

public class PigTest {

    public static void main(String[] args) throws Exception {

        args = new String [] {
                "-x", "local",
                "-e", "explain -script Temp1/TPC_test.pig -out explain-out9.txt"
        };

        PigStats stats = PigRunner.run(args, null);
        //print plan:
        //stats.getJobGraph().explain(System.out, "text", true);
    }

}
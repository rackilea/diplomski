import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static List<Integer> returnInt(String pattern, String inputString) {
        Pattern intPattern = Pattern.compile(pattern);
        Matcher matcher = intPattern.matcher(inputString);
        List<Integer> output = new ArrayList<>();
        while (matcher.find()) {
            output.add(Integer.parseInt(matcher.group(0)));
        }

        return output;
    }

    public static void main(String[] args) {
        System.out
                .println(returnInt(
                        "\\d{5,}",
                        "The following DTE jobs have been submitted to ServerFarm for execution. (farm showjobs -d -j 12774076) can be used to monitor job status. The output format is JobID : TopoName : TopoAlias : JobStatus. ( The initial job status is listed in brackets. If job status is FAILED, then the job can not be run at all! Otherwise please check job status periodically. ) :21554030 : IDM_INSTALLER_1H1N_REL11 : IDM_INSTALLER_1H1N_REL11 : WAITING (Being queueed on server farm)"));
    }
}
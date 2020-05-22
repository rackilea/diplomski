import java.util.ArrayList;

public class Test051 {

    public static void main(String[] args) throws Exception {
        ArrayList<String> timestampsList = new ArrayList<String>();
        timestampsList.add("01:00:05");
        timestampsList.add("01:00:05");
        timestampsList.add("10:00:05");

        long tm = 0;
        for (String tmp : timestampsList){
            String[] arr = tmp.split(":");
            tm += Integer.parseInt(arr[2]);
            tm += 60 * Integer.parseInt(arr[1]);
            tm += 3600 * Integer.parseInt(arr[0]);
        }

        long hh = tm / 3600;
        tm %= 3600;
        long mm = tm / 60;
        tm %= 60;
        long ss = tm;
        System.out.println(format(hh) + ":" + format(mm) + ":" + format(ss));
    }

    private static String format(long s){
        if (s < 10) return "0" + s;
        else return "" + s;
    }
}
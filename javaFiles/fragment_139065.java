package regexpso;

import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(http:.*?.ogg)");
        Matcher m = p.matcher("[playlist]numberofentries=2File1=http://66.162.107.142/cpr1_K128OV.oggTitle1=KCFR NewsLength1=-1File2=http://66.162.107.141:8000/cpr1_K128OV.oggTitle2=KCFR News BackupLength2=-1Version=2");

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
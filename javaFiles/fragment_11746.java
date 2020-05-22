import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main( String args[] ){
        String text = 
            "1   1   Allen, Miss. Elisabeth Walton   female  29  211.3375\n"+
            "1   1   Allison, Master. Hudson Trevor  male    0.9167  151.5500\n"+
            "1   0   Allison, Miss. Helen Loraine    female  2   151.5500\n"+
            "1   0   Allison, Mr. Hudson Joshua Creighton    male    30  151.5500\n"+
            "1   0   Allison, Mrs. Hudson J C (Bessie Waldo Daniels) female  25  151.5500\n"+
            "1   1   Anderson, Mr. Harry male    48  26.5500\n"+
            "1   1   Andrews, Miss. Kornelia Theodosia   female  63  77.9583\n"+
            "1   0   Andrews, Mr. Thomas Jr  male    39  0.0000\n"+
            "1   1   Appleton, Mrs. Edward Dale (Charlotte Lamson)   female  53  51.4792\n"+
            "1   0   Artagaveytia, Mr. Ramon male    71  49.5042\n"+
            "1   0   Astor, Col. John Jacob  male    47  227.5250\n"+
            "1   1   Astor, Mrs. John Jacob (Madeleine Talmadge Force)   female  18  227.5250\n"+
            "1   1   Aubart, Mme. Leontine Pauline   female  24  69.3000\n";

        String lines[] = text.split("\\r?\\n");

        String pattern = "([\\d]) +([\\d]) +(.+\\S) +(female|male) +([\\d.]+)  +([\\d.]+)";
        Pattern r = Pattern.compile(pattern);

        for (String l : lines) {
            Matcher m = r.matcher(l);
            if (m.find( )) {
                System.out.println(" ------------------- New Text Line -------------------");
                System.out.println("Group 1: " + m.group(1) );
                System.out.println("Group 2: " + m.group(2) );
                System.out.println("Group 3: " + m.group(3) );
                System.out.println("Group 4: " + m.group(4) );
                System.out.println("Group 5: " + m.group(5) );
                System.out.println("Group 6: " + m.group(6) );
            } else {
                System.out.println("Line did not match");
            }   
        }
    }
}
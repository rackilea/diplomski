package ic.ac.uk.relationshipvisualiser.app;

import java.util.ArrayList;
import java.util.List;

public class tmpTest3 {

    public static List<String> process(String p_inp) {
        List<String> res = new ArrayList<String>();
        p_inp = p_inp.trim();

        int numberOfOpenBracketsEncountered = 0;

        String t = "";
        String cur = "";

        for (int c=0;c<p_inp.length();c++) {
            cur = p_inp.substring(c,c+1);
            if (cur.equals("(")) {
                numberOfOpenBracketsEncountered++;
            }
            if (cur.equals(")")) {
                numberOfOpenBracketsEncountered--;
            }


            if (cur.equals(",")) {
                if (numberOfOpenBracketsEncountered==0) {
                    if (t.length()>0) res.add(t.trim());
                    t = "";
                } else {
                    cur = cur;
                    t = t + cur;
                }
            } else {
                cur = cur;
                t = t + cur;
            }

        }
        if (t.length()>0) res.add(t.trim());

        return res;
    }

    public static void main(String[] args) {
        System.out.println("Start tmpTest3");

        List<String> inputs = new ArrayList<String>();
        inputs.add("text2(text3, text4), text5(text6, text7)");
        inputs.add("text2, text3(text4, text5(text6, text7))");

        for (int c=0;c<inputs.size();c++) {
            System.out.println("Running test for " + inputs.get(c));
            List<String> res = process(inputs.get(c));
            System.out.println("Got " + res.size() + " strings as a result:");

            for (int d=0;d<res.size();d++) {
                System.out.println(" - :" + res.get(d) + ":");
            }

            System.out.println("----------------------");

        }


        System.out.println("End tmpTest3");
    }   
}
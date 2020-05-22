import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


class Main {
private static HashMap<String,Integer> r2A = new HashMap<String,Integer>();
private static HashMap<Integer,String> a2R = new HashMap<Integer,String>();

public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    makeMaps();
    String read;
    StringBuilder answers = new StringBuilder("");
    while ((read=br.readLine())!=null) {
        int aNum = 0;
        String rNum = "";
        try {
            aNum = Integer.parseInt(read);
            System.out.println(arab2Roman(aNum));
        } catch (NumberFormatException c) {

            rNum = read;

            int ans = roman2Arab(rNum);
            System.out.println(ans);

        }
    }
}

private static int roman2Arab(String rNum) {
    int aNum = 0;
    for (int i = 0; i < rNum.length(); i++) {
        boolean done = false;
        String theNum = rNum.substring(i,i+1);
        if (i < rNum.length()-1) {
            String part = rNum.substring(i, i+2);
            if (r2A.containsKey(part)) {
                aNum+=r2A.get(part);
                i++;
                done = true;
            }
        }
        if (!done) {
            if (r2A.containsKey(theNum)) {
                aNum+=r2A.get(theNum);
            }
        }

    }
    return aNum;
}

private static String arab2Roman(int num) {
    StringBuilder rNum = new StringBuilder("");
    int thousands = num-(num%1000);

    int hundreds = ((num/100)%10)*100;

    int tens = ((num/10)%10)*10;

    int ones = num%10;

    rNum.append(simpleConv(thousands,"thousands"));
    rNum.append(simpleConv(hundreds,"hundreds"));
    rNum.append(simpleConv(tens,"tens"));
    rNum.append(simpleConv(ones,"ones"));

    return rNum.toString();
}

private static String simpleConv(int num, String place) {
    StringBuilder ans = new StringBuilder("");
    int pNum = (place.equals("thousands")) ? 1000 : (place.equals("hundreds")) ? 100 : (place.equals("tens")) ? 10 : 1;
    if (a2R.containsKey(num)) {
        ans.append(a2R.get(num));
    }
    else {
        if (num/pNum>=5) {
            ans.append(a2R.get(5*pNum));
            for (int i = 0; i < ((num/pNum)-5); i++) {
                ans.append(a2R.get(pNum));
            }
        }
        else {
            for (int i = 0; i < num/pNum; i++) {
                ans.append(a2R.get(pNum));
            }
        }
    }
    return ans.toString();
}

private static void makeMaps() {
    // First r2A
    r2A.put("I", 1);
    r2A.put("IV", 4);
    r2A.put("V", 5);
    r2A.put("IX", 9);
    r2A.put("X", 10);
    r2A.put("XL", 40);
    r2A.put("L", 50);
    r2A.put("XC", 90);
    r2A.put("C", 100);
    r2A.put("CD", 400);
    r2A.put("D", 500);
    r2A.put("CM", 900);
    r2A.put("M", 1000);

    // Second a2R
    a2R.put(1, "I");
    a2R.put(4, "IV");
    a2R.put(5, "V");
    a2R.put(9, "IX");
    a2R.put(10, "X");
    a2R.put(40, "XL");
    a2R.put(50, "L");
    a2R.put(90, "XC");
    a2R.put(100, "C");
    a2R.put(400, "CD");
    a2R.put(500, "D");
    a2R.put(900, "CM");
    a2R.put(1000, "M");

}
}
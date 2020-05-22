import java.util.HashMap;

public class Test {

    public static void main(String[] args)  {
        HashMap<String, String> cntrlInfo = new HashMap<String, String>();
        cntrlInfo.put("A", "GBP");
        cntrlInfo.put("B", "001");
        cntrlInfo.put("C", "101");
        cntrlInfo.put("D", "CHDP");
        StringBuilder sb = new StringBuilder();
        for (String val : cntrlInfo.values()) {
            sb.append(val);
        }

        System.out.println("sb = " + sb);
        String ccy = sb.substring(sb.indexOf("GBP"), sb.indexOf("GBP") + 3);
        String foo = sb.substring(sb.indexOf("001"), sb.indexOf("001") + 3);
        String bar = sb.substring(sb.indexOf("101"), sb.indexOf("101") + 3);
        String f = sb.substring(sb.indexOf("CHDP"), sb.indexOf("CHDP") + 4);

        System.out.println("ccy = " + ccy);
        System.out.println("foo = " + foo);
        System.out.println("bar = " + bar);
        System.out.println("f = " + f);
    }
}
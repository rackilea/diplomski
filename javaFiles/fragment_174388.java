public class ConcatenateStrings {
    public static String concateLines(String[] s, String separator) {
        String result = "";  
        StringBuilder sb = new StringBuilder();
        if (s.length > 0) {  
            sb.append(s[0]);
            for (int i = 1; i < s.length; i++) {        
                sb.append(separator);  
                sb.append(s[i]);  
            }
        }
        return sb.toString();
    }
}

public static void main(String[] args) {
 String[] input = {"Test", "input"};
 System.out.println(ConcatenateStrings.concateLines(input, ","));
}
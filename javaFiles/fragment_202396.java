public class SecondMatch {

    public String match(String s) {
        StringBuilder builder = new StringBuilder();
        String[] parts = s.split("\\.");
        for (int i = 0; i < parts.length; i++) {
            builder.append(parts[i]);
            if (i == 0) {
                builder.append(".");
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String s = "123.45.678.7";
        String t = new SecondMatch().match(s);
        System.out.println(s + ", " + t);
    }

}
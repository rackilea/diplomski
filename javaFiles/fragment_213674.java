public class BreakableString {

    private String  string;

    public BreakableString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int maxWidth = 80;
        String s = string;

        while (s.length() > maxWidth) {
            String t = getStringPart(s, maxWidth);
            builder.append(t);
            builder.append(System.getProperty("line.separator"));
            s = s.substring(t.length());
        }

        builder.append(s);

        return builder.toString();
    }

    private String getStringPart(String s, int maxWidth) {
        String t = s.substring(0, maxWidth);
        int ePos = t.lastIndexOf(" ");
        if (ePos > 0) {
            return t.substring(0, ePos);
        } else {
            return t;
        }
    }

}
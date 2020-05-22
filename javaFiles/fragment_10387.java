public class StringUtil {

    public static void main(String args[]) {
        String url = "http://something.com/ \\ponies";
        String newValue = StringUtil.str(url).removeSlashes().removeSpaces().uppercase().getValue();
        System.out.println(newValue);
    }

    private String value;

    public StringUtil(String value) {
        this.value = value;
    }

    public static StringUtil str(String value) {
        return new StringUtil(value);
    }

    public StringUtil removeSlashes() {
        value = value.replace("\\", "");
        return this;
    }

    public StringUtil removeSpaces() {
        value = value.replace(" ", "");
        return this;
    }

    public StringUtil uppercase() {
        value = value.toUpperCase();
        return this;
    }

    public String getValue() {
        return value;
    }
}
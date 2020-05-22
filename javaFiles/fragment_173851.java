public class PhoneNumberFormat {
public static void main(String[] args) {
    String phone = "204.867.5309";
    System.out.println(format(phone));
}

public static String format(String phone) {
    String[] split = phone.split(".");
    split = phone.split("\\.");
    String newPhone = "";
    for (String s : split) {
        newPhone = newPhone + s;

    }
    char[] phoneLine = newPhone.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (char c : phoneLine) {
        if (phoneLine.length == 10
                && Character.isDigit(phoneLine[1])
                && Character.isDigit(phoneLine[0])
                && Character.isDigit(phoneLine[2])
                && Character.isDigit(phoneLine[4])
                && Character.isDigit(phoneLine[5])
                && Character.isDigit(phoneLine[6])
                && Character.isDigit(phoneLine[8])
                && Character.isDigit(phoneLine[9])) {
            sb = new StringBuilder(newPhone);
            sb.append("+1");
            sb.insert(2, "(");
            sb.insert(6, ")");
            sb.insert(10, "-");
        } else {
            throw new IllegalArgumentException("not valid");
        }
    }
    return sb.toString();
}}
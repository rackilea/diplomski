// For use with PasswordField
public static final char BULLET = '\u2022';
. . .
@Override protected String maskText(String txt) {
    if (getSkinnable() instanceof PasswordField) {
        int n = txt.length();
        StringBuilder passwordBuilder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            passwordBuilder.append(BULLET);
        }

        return passwordBuilder.toString();
    } else {
        return txt;
    }
}
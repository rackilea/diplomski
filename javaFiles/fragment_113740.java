char fileSep = '/'; // ... or do this portably.
char escape = '%'; // ... or some other legal char.
String s = ...
int len = s.length();
StringBuilder sb = new StringBuilder(len);
for (int i = 0; i < len; i++) {
    char ch = s.charAt(i);
    if (ch < ' ' || ch >= 0x7F || ch == fileSep || ... // add other illegal chars
        || (ch == '.' && i == 0) // we don't want to collide with "." or ".."!
        || ch == escape) {
        sb.append(escape);
        if (ch < 0x10) {
            sb.append('0');
        }
        sb.append(Integer.toHexString(ch));
    } else {
        sb.append(ch);
    }
}
File currentFile = new File(System.getProperty("user.home"), sb.toString());
PrintWriter currentWriter = new PrintWriter(currentFile);
...

public void setString(int i, String str) {
    str = str.length() > max ? str.substring(0, max) : str;
    target.setString(str, i);
}
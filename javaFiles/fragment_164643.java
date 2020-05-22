private StringBuilder tmp = new StringBuilder();

public void in(String in) {
    tmp.append(in);
}

public String out() {
    return tmp.toString();
}
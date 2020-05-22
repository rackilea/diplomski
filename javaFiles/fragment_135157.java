private String clientInput() {
    String temp = "";
    try {
        temp = in.readLine();
        if (temp == null) {
            out.println("4");
            out.flush();
        } else {
            temp = temp.trim();
        }
    }
    catch (IOException ioe) {
        out.println("6");
        out.flush();
    }
    return temp;
}
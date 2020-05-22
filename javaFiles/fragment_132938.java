public static void main(String[] args) {
    String path = "${file.path}/fld/";
    String realValue = "C:\\\\path\\\\smtg\\\\";  //Notice the double slashes here
    String variable = "${file.path}";
    path = path.replaceAll("\\$\\{" + variable.substring(2, variable.length() - 1) + "\\}", realValue);
    System.out.println(path);
}
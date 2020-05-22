public static String removeSpaces(String input) {
    if (input == null) {
        return "";
    }
    String enter = (char) (13) + (char) (10) + "";
    String tab = (char) (9) + "";
    String space = (char) (32) + "";
    String empty = "";
    return input.replace(enter, empty).replace(tab, empty).replace(space, empty);
}

public static String newLine(){
  return (char) (13) + (char) (10) + "";
}

public static String tab(){
  return (char) (9) + "";
}
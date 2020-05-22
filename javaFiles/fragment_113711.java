public static void buildNameChoicesHelper(String[] nameArray, int nameIndex,
    String str) {

  if(nameIndex >= nameArray.length) {
    if(str.length() > 0) {
      System.out.println(str.substring(0, str.length() - 1));
    }
  }
  else {
    buildNameChoicesHelper(nameArray, nameIndex + 1, str);
    buildNameChoicesHelper(nameArray, nameIndex + 1, str + nameArray[nameIndex] + ".");
  }
}
public static void buildNameChoices(String nameStr) {
  String[] nameArray = nameStr.split("\\.", -1);
  buildNameChoicesHelper(nameArray, 0, "");
}
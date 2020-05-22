public static void buildNameChoicesHelper(String[] nameArray, int nameIndex,
    String firstName, String lastName) {

  if(nameIndex >= nameArray.length) {
    if(lastName.length() > 0) {
      System.out.println(firstName + lastName);
    }
  }
  else {
    buildNameChoicesHelper(nameArray, nameIndex + 1, firstName, lastName);
    buildNameChoicesHelper(nameArray, nameIndex + 1, firstName, lastName + "." + nameArray[nameIndex]);
  }
}
public static void buildNameChoices(String nameStr) {
  String[] nameArray = nameStr.split("\\.", -1);
  for(int i = 0; i < nameArray.length; i++) {
    buildNameChoicesHelper(nameArray, i + 1, nameArray[i], "");
  }
}
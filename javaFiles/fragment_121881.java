for (int i = 0; i < tempArray.length; i++) {

  if (Character.isUpperCase(tempArray[i].charAt(0))) {

    int length = tempArray[i].length();
    //            tempArray[i] = "";
    String result = "";

    for(int j = 0; j < length; j++) {
      if (Character.isLetter(tempArray[i].charAt(j))) {
        result += ('*');
      } else {
        result += tempArray[i].charAt(j);
      }
    }

    System.out.print(" " + result);

  }

  else {
    System.out.print(" " + tempArray[i]);
  }
}
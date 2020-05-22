public static void inputMethod(int length, char letter, int position) {
  // check if input is valid
  if(position < length)
    for (int index = 0; index < wordTable.length; index++) {
      if (length == wordTable[index].length() && letter == wordTable[index].charAt(position) )
            System.out.println(wordTable[index]);
}
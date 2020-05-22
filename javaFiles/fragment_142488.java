if (aryResponse != null) {
  for (int i = 0; i < answersLength; i++) {
    if (answers.charAt(i) == aryResponse[i].charAt(i)) { // what is this testing?
      aryCorrect[i]++;
    }
  }
}
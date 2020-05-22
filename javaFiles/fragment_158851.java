int positionOfLetter = stringToTest.indexOf(letterToCount);
int countNumberOfLetters = 0;

while (positionOfLetter != -1) {
    countNumberOfLetters++;
    positionOfLetter = stringToTest.indexOf(letterToCount, positionOfLetter + 1);
}

System.out.println("Number of letters found: " + countNumberOfLetters);
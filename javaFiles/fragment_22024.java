// declare variable before the if blocks
List<Question> randomList = null;

// get a random int from 0 to 99
int rand = (int) (100 * Math.random());

// get the random list using basic math and if blocks
if (rand < percentEasy) {
    randomList = easyQuestions;
} else if (rand < percentEasy + percentMedium) {
    randomList = mediumQuestions;
} else {
    randomList = hardQuestions;
}
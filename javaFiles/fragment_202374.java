// Create a new questionnaire
Questionnaire questionnaire = new Questionnaire("My awesome questionnaire");

// Lets scan the file and load it up to the questionnaire
Scanner scanner = new Scanner(new File("myfile.txt"));

// Read lines from that file and split it into tokens
String line, tokens[];
int tokenIndex;
while (scanner.hasNextLine() && (line = scanner.nextLine()) != null) {
    tokens = line.split(",");

    // Create the question taking the first token as its text
    Question question = new Question(tokens[0]);

    // Go over the tokens, from the first index to the one before last
    for (tokenIndex = 1; tokenIndex < tokens.length-1; tokenIndex++) {
        // Add the incorrect answer to the question
        question.add(new Answer(tokens[tokenIndex], false));
    }

    // Add the last question (correct one)
    question.add(new Answer(tokens[tokenIndex],true));
}

// Tada! questionnaire is now a complete questionnaire.
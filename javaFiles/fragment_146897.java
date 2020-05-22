public class TriviaGamePlayer {

static class TriviaGame {
  String category;
  String question;
  String answer;
}

public static void main(String[] args) throws IOException {
File gameFile = new File("trivia.txt");

List<TriviaGame> triviaQuestions = new ArrayList<TriviaGame>();
Scanner infile = new Scanner(gameFile);
String lastKnownCategory = "";
Map<String, List<TriviaGame>> map = new HashMap<String, List<TriviaGame>>();

while (infile.hasNextLine()) {
    String currentLine = infile.nextLine();

    if (!currentLine.isEmpty()) {
        TriviaGame currentQuestion;
        if(map.containsKey(lastKnownCategory) == false)
          map.put(lastKnownCategory, new ArrayList<TriviaGame>());

        map.get(lastKnownCategory).add(currentQuestion = new TriviaGame());

        if (currentLine.endsWith("?")) {
            currentQuestion.setCategory(lastKnownCategory);
            currentQuestion.setQuestion(currentLine);
            currentQuestion.setAnswer(infile.nextLine());
        } else {
            currentQuestion.setCategory(currentLine);
            currentQuestion.setQuestion(infile.nextLine());
            currentQuestion.setAnswer(infile.nextLine());
            lastKnownCategory = currentLine;
        }
        triviaQuestions.add(currentQuestion);
    }
}

  infile.close();

  System.out.println(map);
  }
}
import edu.stanford.nlp.ling.Word;

List<Word> words = ...
for (Word word : words) {
  if (word.word().equals(args(1))) {
    System.err.println("Yes!");
  }
}
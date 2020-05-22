import edu.stanford.nlp.simple.*;

Document doc = new Document("My 1st sentence. “Does it work for questions?” My third sentence.");
for (Sentence sentence : doc.sentences()) {
  System.out.println(sentence.characterOffsetBegin(0) + " -- " + sentence.characterOffsetEnd(sentence.length() - 1));
}
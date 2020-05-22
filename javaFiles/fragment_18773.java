class Ngram { }
class Ugram extends Ngram { }
class Bigram extends Ngram { }

public class NgramFactory {
    public static Ngram createNgram(int n) {
        if (n ==1) {
            return new Ugram();
        } else {
            return new Bigram();
        }
    }
}
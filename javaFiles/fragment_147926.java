public static void main(String[] args) throws Exception {
    double tweetcount = 3344048;
    double emotionCount = 855937;
    double emotionCountSentence = 84988;

    double result = emotionCountSentence / (tweetcount * emotionCount);

    System.out.println("result = " + result);
}
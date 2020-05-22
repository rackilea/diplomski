public class PlaygroundMain {

        public static void main(String... args) {
                Scanner sc = new Scanner(System.in);
                PlaygroundMain gameDemo = new PlaygroundMain();
                System.out.println("Shuffling the cards");
                List<FlashCard> shuffledDeck = gameDemo.getQuestions();
                Collections.shuffle(shuffledDeck);
                System.out.println("Cards Shuffled!");
                int score = 0;

                for (FlashCard card : shuffledDeck) {
                        System.out.println(card.getQuestion());
                        final String answer = sc.nextLine();

                        if (answer.trim().equals(card.getAnswer())) {
                                System.out.println("You have answered right!, giving you a point");
                                score++;
                        } else {
                                System.out.println("Sorry, you have answered wrong, the correct answer is: "+card.getAnswer());
                        }

                        if (shuffledDeck.indexOf(card) != shuffledDeck.size()-1) {
                                System.out.println("Preparing next question...");
                        }
                }

                System.out.println("Your score is: "+score);
        }


        public List<FlashCard> getQuestions() {
                FlashCard c1 = new FlashCard("Q1: What is my name?", "Alfred");
                FlashCard c2 = new FlashCard("Q2: What is my age?", "26");
                return Arrays.asList(c1, c2);
        }

        class FlashCard {
                private final String question;
                private final String answer;

                public FlashCard(String question, String answer) {
                        this.question = question;
                        this.answer = answer;
                }


                public String getQuestion() {
                        return question;
                }

                public String getAnswer() {
                        return answer;
                }

        }
}
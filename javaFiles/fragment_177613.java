public class Question {
    String question;
    String[] answers = new String[4];

    public Question(String question, String[] answers){
        this.question = question;
        this.answers = answers;
    }

    @Override
    public String toString() {
        return question+"\n" + Arrays.toString(answers);
    }

    public static void main(String[] args) {
        String[] options = new String[4];
        int counter = 0;

        List<Question> list = new ArrayList<Question>();

        for (int i = 0;i<10;++i) {
            for(int j = 0;j<4;++j,++counter) {
                options[j] = counter+"";
            }
            Question q = new Question(counter+"",options);
            list.add(q);
        }

        for(Question q : list) {
            System.out.println(q);
        }


    }
}
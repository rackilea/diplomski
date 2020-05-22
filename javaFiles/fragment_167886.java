public class Radios extends Application {

    class Survey {
        private ObservableList<Question> questions = FXCollections.observableArrayList();

        public ObservableList<Question> getQuestions() {
            return questions;
        }
    }

    class Question {

        private StringProperty text = new SimpleStringProperty("");
        private BooleanProperty answer = new SimpleBooleanProperty(false);


        public Question(String text) {
            setText(text);
        }


        public boolean isAnswer() {
            return answer.get();
        }

        public BooleanProperty answerProperty() {
            return answer;
        }

        public void setAnswer(boolean answer) {
            this.answer.set(answer);
        }


        public String getText() {
            return text.get();
        }

        public StringProperty textProperty() {
            return text;
        }

        public void setText(String text) {
            this.text.set(text);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Model
        Survey survey = new Survey();
        for (int i = 0; i<300; i++) {
            Question question = new Question("Do you like number " + i + "?");
            question.answerProperty().addListener((obs, oldval,newval) -> {
                System.out.println("Question: " + question.getText() + " answer changed from " + oldval + " to " + newval);
            });
            survey.getQuestions().add(question);
        }

        // View
        VBox root = new VBox();
        root.setSpacing(10);

        for (Question question : survey.getQuestions()) {

            VBox vBox = new VBox();
            vBox.setSpacing(5);
            HBox answerHBox = new HBox();
            answerHBox.setSpacing(20);
            vBox.getChildren().addAll(new Label(question.getText()), answerHBox);

            RadioButton yes = new RadioButton("Yes");
            RadioButton no = new RadioButton("No");
            ToggleGroup toggleGroup = new ToggleGroup();

            yes.setToggleGroup(toggleGroup);
            no.setToggleGroup(toggleGroup);

            answerHBox.getChildren().addAll(yes, no);
            yes.setSelected(question.isAnswer());
            no.setSelected(!question.isAnswer());

            toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                question.setAnswer(newValue.equals(yes));
            });


            root.getChildren().add(vBox);

        }

        Scene scene = new Scene(new ScrollPane(root), 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
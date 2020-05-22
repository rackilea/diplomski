package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.geometry.*;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import java.util.Random;

public class test extends Application {

    Stage window;
    Label label1 = new Label();
    Scene scene1, scene2;

    //ScoreBoard Rectangles
    Group userScoreRoot, computerScoreRoot;

    public static ScoreBoard userScoreBoard = new ScoreBoard();
    public static ScoreBoard computerScoreBoard = new ScoreBoard();
    public static final int ROCK = 0;
    public static final int PAPER = 1;
    public static final int SCISSORS = 2;
    public static int userChoice;
    public static int compChoice;
    public static int userCounter = 0;
    public static int compCounter = 0;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setResizable(false);


        //Layouts
        VBox layout = new VBox(20);
        HBox hbox = new HBox(10);

        //Background color
        BackgroundFill backFill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backFill);
        layout.setBackground(background);

        //Start Screen Label
        Label label = new Label("Rock Paper Scissors");
        label.setFont(Font.font(20));
        label.setTextFill(Color.WHITE);

        //Start Button
        Button myButton = new Button("Start");
        myButton.setOnAction(e -> window.setScene(scene2));

        //Exit Button
        Button exit = new Button("Exit");
        exit.setOnAction(e -> System.exit(0));

        //Add Children
        hbox.getChildren().addAll(myButton, exit);
        hbox.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, hbox);
        layout.setAlignment(Pos.CENTER);

        //Add to scene1
        scene1 = new Scene(layout, 300, 300, Color.BLACK);

        //Layout 2
        VBox layout1 = new VBox(10);
        label1.setText(" \n ");
        label1.setFont(Font.font(18)); //Setting font size
        label1.setTextFill(Color.WHITE);
        label1.setTextAlignment(TextAlignment.CENTER);
        label.setTextFill(Color.WHITE);
        layout1.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(10);
        HBox layout2 = new HBox(10);
        HBox lay2 = new HBox(10);


        //ScoreBoard Created
        userScoreRoot = userScoreBoard.getRoot();
        computerScoreRoot = computerScoreBoard.getRoot();

        //Rock Button
        Button rock = new Button("Rock");
        rock.setOnAction(e -> {
            userChoice = ROCK;
            compChoice = compChoice();
            winner(label1);
        });
        //Paper Button
        Button paper = new Button("Paper");
        paper.setOnAction(e -> {
            userChoice = PAPER;
            compChoice = compChoice();
            winner(label1);
        });
        //Scissor Button
        Button scissors = new Button("Scissors");
        scissors.setOnAction(e -> {
            userChoice = SCISSORS;
            compChoice = compChoice();
            winner(label1);
        });

        //Quit Button
        Button quit = new Button("Return");
        quit.setOnAction(e -> window.setScene(scene1));

        Region region1 = new Region();
        Region region2 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        HBox.setHgrow(region2, Priority.ALWAYS);
        HBox scoreBox = new HBox(40);
        scoreBox.getChildren().addAll(region1, userScoreRoot, computerScoreRoot, region2);

        //Add Children
        lay2.getChildren().add(label1);
        lay2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(rock, paper, scissors, quit);
        layout2.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(scoreBox, lay2, layout2);
        vbox.setBackground(background);

        //Add to scene2
        scene2 = new Scene(vbox, 300, 300);

        window.setTitle("Rock Paper Scissors");
        window.setScene(scene1);
        window.show();
    }

    public static int compChoice() {
        Random rand = new Random();

        int randNum = rand.nextInt(3);

        return randNum;
    }

    public static void winner(Label label1) {
        /*String[] result = new String[] {"TIE\n ", "You WIN\n ", "You LOSE\n "}; 
        String[] choice = new String[] {"Rock", "Paper", "Scissors"};
        int index = Math.abs(((userChoice - compChoice) % 3));
        String answer = result[index];
        if(index == 1) {
            userCounter++;
            answer += choice[userChoice] + " beats " + choice[compChoice];
        }
        else if(index == 2) {
            compCounter++;
            answer += choice[compChoice] + " beats " + choice[userChoice];
        }
        label1.setText(answer);*/
        if (userChoice == ROCK && compChoice == SCISSORS) {
            label1.setText("You WIN\nRock beats Scissors");
            userCounter++;
        }

        if (userChoice == ROCK && compChoice == PAPER) {
            label1.setText("You LOSE\nPaper beats Rock");
            compCounter++;
        }

        if (userChoice == PAPER && compChoice == ROCK) {
            label1.setText("You WIN\nPaper beats Rock");
            userCounter++;
        }

        if (userChoice == PAPER && compChoice == SCISSORS) {
            label1.setText("You LOSE\nScissors beats Paper");
            compCounter++;
        }

        if (userChoice == SCISSORS && compChoice == ROCK) {
            label1.setText("You LOSE\nRock beats Scissors");
            compCounter++;
        }

        if (userChoice == SCISSORS && compChoice == PAPER) {
            label1.setText("You WIN\nScissors beats Paper");
            userCounter++;
        }

        if (userChoice == compChoice)
            label1.setText("TIE\n    ");

        userScoreBoard.setScore(userCounter);
        computerScoreBoard.setScore(compCounter);
    }

}
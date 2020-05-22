package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ScoreBoard {

    Rectangle r,r1,r2,r3,r4,r5,r6;
    Rectangle[] display;
    Group root;

    public ScoreBoard() {
        r = new Rectangle(10,10,10,40); //10 , 50

        r1 = new Rectangle(20,0,40,10); //20 , 40

        r2 = new Rectangle(60,10,10,40); //60 , 50

        r3 = new Rectangle(20,50,40,10); //20 , 90

        r4 = new Rectangle(10,60,10,40); // 10 , 100

        r5 = new Rectangle(60,60,10,40); //60 , 100

        r6 = new Rectangle(20,100,40,10); //20 , 140

        display = new Rectangle[]{r,r1,r2,r3,r4,r5,r6};
        for(Rectangle rec : display) {
            rec.setArcWidth(20);
            rec.setArcHeight(20);
        }

        root = new Group(display);
    }

    public void clearRect() {
        for(Rectangle r : display) r.setFill(Color.BLACK);
    }

    public void setScore(int score) {
        clearRect();
        switch (score%9) {
            case 0:
                 r.setFill(Color.RED);
                 r1.setFill(Color.RED);
                 r2.setFill(Color.RED);
                 r4.setFill(Color.RED);
                 r5.setFill(Color.RED);
                 r6.setFill(Color.RED);
                 break;
            case 1:
                r2.setFill(Color.RED);
                r5.setFill(Color.RED);
                break;
            case 2:
                r1.setFill(Color.RED);
                r2.setFill(Color.RED);
                r3.setFill(Color.RED);
                r4.setFill(Color.RED);
                r6.setFill(Color.RED);
                break;
            case 3:
                r1.setFill(Color.RED);
                r2.setFill(Color.RED);
                r3.setFill(Color.RED);
                r5.setFill(Color.RED);
                r6.setFill(Color.RED);
                break;
            case 4:
                r.setFill(Color.RED);
                r2.setFill(Color.RED);
                r3.setFill(Color.RED);
                r5.setFill(Color.RED);
                break;
            case 5:
                r.setFill(Color.RED);
                r1.setFill(Color.RED);
                r3.setFill(Color.RED);
                r5.setFill(Color.RED);
                r6.setFill(Color.RED);
                break;
            case 6:
                r.setFill(Color.RED);
                r1.setFill(Color.RED);
                r3.setFill(Color.RED);
                r4.setFill(Color.RED);
                r5.setFill(Color.RED);
                r6.setFill(Color.RED);
                break;
            case 7:
                r1.setFill(Color.RED);
                r2.setFill(Color.RED);
                r5.setFill(Color.RED);
                break;
            case 8:
                r.setFill(Color.RED);
                r1.setFill(Color.RED);
                r2.setFill(Color.RED);
                r3.setFill(Color.RED);
                r4.setFill(Color.RED);
                r5.setFill(Color.RED);
                r6.setFill(Color.RED);
                break;
            case 9:
                r.setFill(Color.RED);
                r1.setFill(Color.RED);
                r2.setFill(Color.RED);
                r3.setFill(Color.RED);
                r5.setFill(Color.RED);
                r6.setFill(Color.RED);
                break;
            default: break;
        }

    }

    public Group getRoot() {
        return this.root;
    }
}
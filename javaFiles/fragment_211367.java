public class Game {

    ...

    public void gameStart(){

        ...

        // setting up the scene
        scene = new Scene(window, 800, 600);

        // adding css
        scene.getStylesheets().add(this.getClass().getResource("game.css").toExternalForm());

        setLevel("Storyline");
    }

    public void setLevel(String newLevel) {
         // TODO: integrate gameOn value
         if (newLevel != null && !newLevel.equals(levels)) {
              levels = newLevel;
              switch (levels) {
                case "Storyline":
                    btn1.setText("search around");
                    btn2.setText("turn the light on");
                    btn3.setText("stand in fear");

                    // user interaction triggers setting the level
                    btn2.setOnAction(e -> setLevel("level1"));
                    break;
                case "level1":
                    topText.setText("You turned the light on");
                    break;
            }
         }
    }

    ...

}
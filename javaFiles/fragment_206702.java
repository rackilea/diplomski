private double x = 0; //instance variable

game.setOnKeyPressed(e->begin()); 

public void begin() {
    x += birdView.getTranslateX()-100;   
    birdView.setTranslateY(x);
}
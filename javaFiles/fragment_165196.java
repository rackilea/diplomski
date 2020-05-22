int p1diceroll=0;
int p2diceroll=0;

String result = "";

void setup(){
    size (120,120);
    background(200,200,200); 
    println("press l to roll the die!");
}

void draw() {
  background(0);
  text("press 'l' for p1"
      +"\npress 'a' for p2"
      +"\n\np1diceroll: " + p1diceroll
      +"\np2diceroll: " + p2diceroll
      +"\n\n"+result,5,15);
}

void keyPressed(){
    if (key == 'l') {
        p1diceroll = (int)random(1,7);

        println("You(p1) rolled a " + p1diceroll + "!"); 
        println("player 2! press 'a' to roll");
    }

    if (key == 'a') {
        p2diceroll = (int)random(1,7);

        println("You(p2) rolled a " + p2diceroll + "!");

        if (p2diceroll > p1diceroll) {
          println("player 2  rolled higher(" + p2diceroll + " > " + p1diceroll + ")!. They go first. ");
          result = "player 2\ngoes first";
        } else if (p2diceroll == p1diceroll) {
          println("It's a tie! player 1 goes first by default." );
          result = "tie! player 1\ngoes first";
        } else {
          println("player 1 rolled higher(" + p1diceroll + " > " + p2diceroll + ")! They go first.");
          result = "player 1\ngoes first";
        }
    }
}
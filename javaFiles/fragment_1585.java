public class Game {

private StageObj gamestage = null;
private PlayerObj player = null;

public Game(
    boolean createstage, //For sorting purposes
    int slength, 
    int sheight, 
    boolean createplayer, 
    int plength, 
    int pheight, 
    boolean playersprite,
    BufferedImage psprite, 
    boolean defaultcontrols,
    String pcontrols, 
    boolean test
    ) {
if(test == true) { //if test is true, test
    new Test();
}else{ //otherwise create a stage is createstage is true and
    if(createstage == true) {
        gamestage = new StageObj(slength, sheight);
    }
    if(createplayer==true) {
        player = new PlayerObj(plength, pheight, psprite, pcontrols);
    }
}
}

public Game() {
    gamestage = new StageObj(100, 100);
    player = new PlayerObj(10, 10);
}

public StageObj givestageobj() {
    return gamestage;
}

public PlayerObj giveplayerobj() {
    return player;
}

}
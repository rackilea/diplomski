public class ResourceManager {

    private Hero hero;
    private Enemy enemy;
    private MenuButtons mainMenuButtons;
    private Background background;
    private Scene mainMenu;

    public void createObjects(){

        hero = new Hero();
        enemy = new Enemy();
        mainMenuButtons = new MenuButtons();
        background = new Background();
        mainMenu = new Scene(this);

    }

    public void render(Scene scene) {

        this.background.draw();
        if (scene != mainMenu) {

            this.hero.draw();
            this.enemy.draw();
        }
        this.mainMenuButtons.draw();           

    }

    public void updateLogic(Scene scene){

        this.hero.move();
        this.enemy.move();
        this.mainMenubuttons.animate();
    }

}
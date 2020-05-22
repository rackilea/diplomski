public class Resources {

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

    public Hero getBackground() {

        return background;
    }

    public Hero getHero() {

        return hero;
    }

    public List<Enemy> getEnemies() {

        ArrayList<Enemy> list = new ArrayList<Enemy>();
        list.add(enemy);
        list.add(next_enemy);
        return list;
    }

    public List<Sprite> getSprites() {

        ArrayList<Sprite> list = new ArrayList<Sprite>();
        list.addAll(enemy.getActiveSprites());
        return list;
    }

}
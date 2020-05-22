private GameScreen gs;

private boolean gameRunning = true;
private int fps;

private Entity player;

//private Entity gost; Removed because I don't think you need this. 

private ArrayList<Entity> entityList = new ArrayList<>();

private HashMap<String, Boolean> keyDown = new HashMap<>();

public void loadObjects() {
    Image playerImg = new ImageIcon(getClass().getResource("/playerImg.png")).getImage();
    Image gostImg = new ImageIcon(getClass().getResource("/gostImg.png")).getImage();

    player = new Entity(playerImg, 100, 200, 200);
    //entityList.add(player); I don't think you need this either, unless you check all of your entities in your checkCollisionandRemove() method

    //Create your "Gost" entities this way.
    entityList.add(new Entity(gostImg, 224, 350, 10));
    entityList.add(new Entity(gostImg, 460, 20, 10));
    entityList.add(new Entity(gostImg, 624, 300, 10));
    entityList.add(new Entity(gostImg, 942, 550, 20));
    entityList.add(new Entity(gostImg, 520, 760, 30));
}
public void update(long deltaTime) {
    checkCollisionandRemove();

    if(keyDown.get("right")) {
        player.setDirectionX(1);
        player.setDirectionY(0);
    }
    else if(keyDown.get("left")){
        player.setDirectionX(-1);
        player.setDirectionY(0);
    }

    if(keyDown.get("up")) {
        player.setDirectionY(-1);
        player.setDirectionX(0);
    }
    else if(keyDown.get("down")) {
        player.setDirectionY(1);
        player.setDirectionX(0);
    }

    if(player.getX() < 0) {
        player.setX(0);
    }

    if(player.getX() > gs.getWidth() -  player.getWidth()) {
        player.setX(gs.getWidth() -  player.getWidth());
    }

    if(player.getY() < 0) {
        player.setY(0);
    }

    if(player.getY() > gs.getHeight() -  player.getHeight()) {
        player.setY(gs.getHeight() -  player.getHeight());
    }

    player.moveX(deltaTime);
    player.moveY(deltaTime);

    //Move each gost this way.
    for(Entity entity : entityList) {   
        /*
            If you need to include your player object into the entity list you will need a way to tell whether entity is a gost or player.
            Something like: if(entity.getType().equalsIgnoreCase("gost")) then move
        */

        entity.moveX(deltaTime);
        entity.moveY(deltaTime);
    }
}
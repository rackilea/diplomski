private BulletAppState bulletAppState;
private Node gameLevel;
private PhysicsCharacter player;
private Vector3f walkDirection = new Vector3f();
private boolean left=false,right=false,up=false,down=false;
@Override
public void simpleUpdate(float tpf) {
    Vector3f camDir = cam.getDirection().clone().multLocal(0.6f);
    Vector3f camLeft = cam.getLeft().clone().multLocal(0.4f);
    walkDirection.set(0,0,0);
    if(left)
        walkDirection.addLocal(camLeft);
    if(right)
        walkDirection.addLocal(camLeft.negate());
    if(up)
        walkDirection.addLocal(camDir);
    if(down)
        walkDirection.addLocal(camDir.negate());
    player.setWalkDirection(walkDirection);
    cam.setLocation(player.getPhysicsLocation());
}

private void setupKeys() {
    inputManager.addMapping("Lefts", new KeyTrigger(KeyInput.KEY_A));
    inputManager.addMapping("Rights", new KeyTrigger(KeyInput.KEY_D));
    inputManager.addMapping("Ups", new KeyTrigger(KeyInput.KEY_W));
    inputManager.addMapping("Downs", new KeyTrigger(KeyInput.KEY_S));
    inputManager.addMapping("Space", new KeyTrigger(KeyInput.KEY_SPACE));
    inputManager.addListener(this,"Lefts");
    inputManager.addListener(this,"Rights");
    inputManager.addListener(this,"Ups");
    inputManager.addListener(this,"Downs");
    inputManager.addListener(this,"Space");
}

public void onAction(String binding, boolean value, float tpf) {

    if (binding.equals("Lefts")) {
        if(value)
            left=true;
        else
            left=false;
    } else if (binding.equals("Rights")) {
        if(value)
            right=true;
        else
            right=false;
    } else if (binding.equals("Ups")) {
        if(value)
            up=true;
        else
            up=false;
    } else if (binding.equals("Downs")) {
        if(value)
            down=true;
        else
            down=false;
    } else if (binding.equals("Space")) {
        player.jump();
    }
}
@Override
public boolean keyDown(int keycode) {
    if (keycode == Keys.NUM_1) {
        referenceSpell = new FlameSpell(player, tmp.x, tmp.y, .2f);
    }
    if (keycode == Keys.NUM_2) {
        referenceSpell = new HealthRingSpell(player, tmp.x, tmp.y, .2f);
    }
}

public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    tmp.x = screenX;
    tmp.y = screenY;
    tmp.z = 0;
    cam.unproject(tmp);
    //stage.addSpell(referenceSpell); //already added in ctor
    //stageSpells.add(referenceSpell);
    grid.checkAndDestroy(new Vector2(tmp.x, tmp.y));
    return false;
}
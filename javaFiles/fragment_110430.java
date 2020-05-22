@Override
public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    if (state != STATE.GAMEOVERLOST && state != STATE.PAUSED
            && state != STATE.EXITMENU && !slowButton.isOver()
            && !stage.hit(screenX, screenY, true).equals(pauseButton))
        turret.setTargetAngle(screenX, screenY);
    return true;
}
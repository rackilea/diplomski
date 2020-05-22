Timer timer = new Timer();
timer.schedule(new TimerTask() {
    public void run() {
        checkKeyStrokes();
    }
}, 0, 0135);

public void checkKeyStrokes(){
    if (movementBitKeys.isKeyPressed(87)){ //w
        keyPressed(87);
    }
    if (movementBitKeys.isKeyPressed(65)){ //a
        keyPressed(65);
    }
    if (movementBitKeys.isKeyPressed(83)){ //s
        keyPressed(83);
    }
    if (movementBitKeys.isKeyPressed(68)){ //d
        keyPressed(68);
    }
}
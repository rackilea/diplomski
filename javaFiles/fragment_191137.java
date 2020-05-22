Boolean prevState = previousCollisionStateMap.get(id);
if (prevState == null) {  // this is just to initialize value
    prevState = false;
    previousCollisionStateMap.put(id,false);
}

if (!prevState && collisionDetected) {
    score.setText(Integer.toString(currentScore.getCurrentValue()));
    currentScore.incrementBy(10);
    rect.setFill(Color.BLUE);
}
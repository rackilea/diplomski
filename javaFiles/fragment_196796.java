enum Gesture {ROCK, SCISSOR; PAPER}

Map<Gesture, ImageIcon> leftImages;
Map<Gesture, ImageIcon> rightImages;

Gesture rightGesture;
Gesture leftGesture;

void setLeftGesture(Gesture gesture) {
    leftGesture = gesture;
    setLeftImage(leftImages.get(gesture);
}

//TODO
void setRightGesture(...);

boolean isEqualGesture(){
    return rightGesture == leftGesture;
}

boolean leftWins(){
    return rightGesture == Gesture.ROCK && leftGesture == Gesture.PAPER;
}

//TODO
boolean rightWins(){...}
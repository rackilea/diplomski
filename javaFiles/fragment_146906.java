if (x > position.x){
    position.x += speed * deltaTime; //if close to touch point, position.x is now bigger than x
}
if (x < position.x){ //if we just moved right past the touch point, undo it
    position.x -= speed * deltaTime;
}
class Animator{
    void animateBall(){
    Ball ball = buildBall(); //Ball will have i,j,radius etc set by this method
    int vx = randomNumber();
    int vy = randomNumber();
    moveIt(vx,vy, ball);
    }
    void moveIt(int vx, int vy, Ball ball){
        while(true){
             //move the ball, change i,j fields of ball
             //check for collission etc
             Collider collider = getCollider(ball);
             //change direction based on collider etc.
        }
    }
    Collider getCollider(Ball ball){
    //collision code here
    }
}
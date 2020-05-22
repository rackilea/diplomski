if(Collision(net, ball))
{
    isCollide = true; //first collision occur
    points += 1;//POINT INCREASE
    this.score.setText("Score: " + points);
}
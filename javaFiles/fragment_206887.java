MyObject obstacleHoleA = new MyObject();
MyObject obstacleHoleB = new MyObject();

obstacleHoleA.paint(g);

if(obstacleHoleA.getX() <= 0){
    obstacleHoleB.paint(g);
}
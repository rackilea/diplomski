public void updateGravitation() {

    for (GravitationalBody aGravitationalBody : gravitationalBodies){
        double sumX = 0;
        double sumY = 0;
        for (GravitationalBody bGravitationalBody : gravitationalBodies){
            if (aGravitationalBody != bGravitationalBody) {

                double massMultiplication = aGravitationalBody.getMass() * bGravitationalBody.getMass();

                double distanceX = aGravitationalBody.getPosition().x - bGravitationalBody.getPosition().x;
                double distanceY = aGravitationalBody.getPosition().y - bGravitationalBody.getPosition().y;

                double r = Math.sqrt(Math.pow(distanceX,2) + Math.pow(distanceY,2));

                double force = G * massMultiplication/(r * r);

                sumX += -1*force * distanceX/r;
                sumY += -1*force * distanceY/r;

            }
        }
        aGravitationalBody.appleForce(sumX,sumY);
    }
}
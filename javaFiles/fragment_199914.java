if (oldX < 0.0005 && oldY < 0.0005) {
    oldX = e.getX();
    oldY = e.getY();
} else {
    float differenceX = e.getX() - oldX;
    float differenceY = e.getY() - oldY;

    oldX = e.getX();
    oldY = e.getY();

    // getting the current position of the camera in the spherical coordinate system

    Vector3f sphericalCoords = MathUtils.toSphericalCoords(camera.getPosition());

    float speedY = (float)Math.toRadians(differenceY / 4.0f);
    float speedX = (float)Math.toRadians(differenceX / 4.0f);

    // adding speedY to the theta angle and speedX to the phi angle

    sphericalCoords.add(new Vector3f(0, speedY, speedX));

    // making sure the angles are not outside the [0, 2 * PI] interval

    polarCoords.y = MathUtils.wrapTo2Pi(sphericalCoords.y);
    polarCoords.z = MathUtils.wrapTo2Pi(sphericalCoords.z);

    // updating the position of the camera

    camera.setPosition(MathUtils.toCartesianCoords(sphericalCoords));
}
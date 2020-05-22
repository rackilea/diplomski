//drive along the ship's nose line
void moveAlongShipAxis(int magnitude) {
    x += magnitude * Math.cos(Math.toRadians(r));
    y += magnitude * Math.sin(Math.toRadians(r));       
}
//strafe left and right, if you have that, otherwise you can skip this one
void moveYAlongTransverseAxis(int magnitude) {
    y += magnitude * Math.cos(Math.toRadians(r));
    x += magnitude * Math.sin(Math.toRadians(r));       
}
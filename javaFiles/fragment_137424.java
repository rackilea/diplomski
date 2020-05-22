if(Mouse.isButtonDown(0)){
    float dx =  delta * (Mouse.getDX() * 2);
    float dy = -delta * (Mouse.getDY() * 2);
    float c = Math.cos(angleArroundTarget);
    float s = Math.sin(angleArroundTarget);
    targetPosition.x += c * dx - s * dy;
    targetPosition.z += s * dx + c * dy;
}
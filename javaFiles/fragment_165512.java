float angleToTree = Math.atan2(tree.location.z - camera.z(), tree.location.x - camera.x());
float angleDiff = angleToTree - camera.yaw();
if (angleDiff > Math.PI)
    angleDiff -= 2.0f * Math.PI;
if (angleDiff < -Math.PI)
    angleDiff += 2.0f * Math.PI;
if (abs(angleDiff) < cameraFOV + 0.1f) //bias as trees are not points
    tree.render();
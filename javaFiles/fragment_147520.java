Vector3f xAxis = new Vector3f(
    cosYaw*cosPitch,
    cosYaw* sinPitch*sinRoll - sinYaw*cosRoll,
    cosYaw*sinPitch*cosRoll + sinYaw*sinRoll
);

Vector3f yAxis = new Vector3f(
    sinYaw*cosPitch,
    sinYaw*sinPitch*sinRoll + cosYaw*cosRoll,
    sinYaw*sinPitch*cosRoll - cosYaw*sinRoll
);
Vector3f zAxis = new Vector3f(
    -sinPitch,
    cosPitch*sinRoll,
    cosPitch * cosYaw
);
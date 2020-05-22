public final Matrix4 lookAt(Vector3 eye, Vector3 center)
{
    float dx = eye.x - center.x;
    float dy = eye.y - center.y;
    float dz = eye.z - center.z;

    float pitch = (float) Math.atan2(dy, Math.sqrt(dx * dx + dz * dz));
    float yaw = (float) Math.atan2(dz, dx);

    pitch = -pitch;
    yaw = yaw - 1.57079633f;

    Matrix4 camera_matrix = new Matrix4();

    matrix.identity();

    matrix.rotate(pitch, -1f, 0f, 0f);
    matrix.rotate(yaw, 0f, 1f, 0f);

    matrix.translate(-eyex, -eyey, -eyez);

    return matrix;
}
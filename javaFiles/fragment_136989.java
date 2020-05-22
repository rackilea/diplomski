public static final Vector3f getRotationVector(float pitch, float yaw, float roll){
    float r = (float) toRadians(roll);
    Matrix4f mat = createTransformationMatrix(new Vector3f(), pitch, yaw, 0, 1);
    Vector3f vector = new Vector3f(mat.m20, mat.m21, -mat.m22);
    return new Vector3f((float)(vector.x * cos(r) + vector.y * sin(r)), (float)(vector.y * cos(r) - vector.x * sin(r)), vector.z);
}
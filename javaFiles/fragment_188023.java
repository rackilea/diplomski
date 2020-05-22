public Vector4F multiplyAsQuat(Vector3F v) {
    float o = -x * v.getX() - y * v.getY() - z * v.getZ();
    float a = w * v.getX() + y * v.getZ() - z * v.getY();
    float b = w * v.getY() + z * v.getX() - x * v.getZ();
    float c = w * v.getZ() + x * v.getY() - y * v.getX();

    return new Vector4F(a, b, c, o);
}

    public Vector4F conjugate() {
    return new Vector4F(-x, -y, -z, w);
}

    public Vector4F multiplyAsQuat(Vector4F qt) {

    float o = w * qt.getW() - x * qt.getX() - y * qt.getY() - z * qt.getZ();
    float a = x * qt.getW() + w * qt.getX() + y * qt.getZ() - z * qt.getY();
    float b = y * qt.getW() + w * qt.getY() + z * qt.getX() - x * qt.getZ();
    float c = z * qt.getW() + w * qt.getZ() + x * qt.getY() - y * qt.getX();

    return new Vector4F(a, b, c, o);
}
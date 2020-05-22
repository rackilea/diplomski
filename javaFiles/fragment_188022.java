public Vector3F rotate(float angle, Vector3F axis) {
    double a = Math.toRadians(angle / 2f);
    float hs = (float) Math.sin(a);
    float hc = (float) Math.cos(a);
    Vector4F r = new Vector4F(axis.getX() * hs, axis.getY() * hs, axis.getZ() * hs, hc);
    Vector4F rc = r.conjugate();
    r = r.multiplyAsQuat(this).multiplyAsQuat(rc);

    return new Vector3F(r.getX(), r.getY(), r.getZ());
    }
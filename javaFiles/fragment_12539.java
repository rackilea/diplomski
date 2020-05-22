public static Mat4 lookAt(Vec3 eye, Vec3 center, Vec3 up) {

    Vec3 f = normalize(Vec3.sub(center, eye));
    Vec3 u = normalize(up);
    Vec3 s = normalize(cross(f, u));
    u = cross(s, f);

    Mat4 result = new Mat4(1.0f);
    result.set(0, 0, s.x);
    result.set(1, 0, s.y);
    result.set(2, 0, s.z);
    result.set(0, 1, u.x);
    result.set(1, 1, u.y);
    result.set(2, 1, u.z);
    result.set(0, 2, -f.x);
    result.set(1, 2, -f.y);
    result.set(2, 2, -f.z);

    return translate(result, new Vec3(-eye.x,-eye.y,-eye.z));
}
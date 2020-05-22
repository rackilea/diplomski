public static MassData calculateMassData(List<Vector2> vertices,
        float density) {
    float k_inv3 = 1.0f / 3.0f;
    float area = 0.0f;
    float I = 0.0f;
    Vector2 center = new Vector2();

    Vector2 s = new Vector2();
    for (int i = 0, size = vertices.size(); i < size; i++) {
        s.add(vertices.get(i));
    }
    s.div(vertices.size());

    for (int i = 0, size = vertices.size(); i < size; ++i) {
        // Triangle vertices.
        Vector2 e1 = new Vector2(vertices.get(i));
        e1.sub(s);
        Vector2 e2 = new Vector2(i + 1 < size ? vertices.get(i + 1)
                : vertices.get(0));
        e2.sub(s);

        float D = e1.crs(e2);

        float triangleArea = 0.5f * D;
        area += triangleArea;

        // Area weighted centroid
        center.add(e1.cpy().add(e2).mul(k_inv3).mul(triangleArea));

        float ex1 = e1.x, ey1 = e1.y;
        float ex2 = e2.x, ey2 = e2.y;

        float intx2 = ex1 * ex1 + ex2 * ex1 + ex2 * ex2;
        float inty2 = ey1 * ey1 + ey2 * ey1 + ey2 * ey2;

        I += (0.25f * k_inv3 * D) * (intx2 + inty2);
    }

    MassData data = new MassData();
    // Total mass
    data.mass = density * area;

    center.mul(1.0f / area);
    data.center.set(center.cpy().add(s));
    // Inertia tensor relative to the local origin (point s).
    data.I = density * I;

    // Shift to center of mass then to original body origin.
    data.I += data.mass
            * (data.center.dot(data.center) - center.dot(center));
    data.I = (data.I);
    return data;
}
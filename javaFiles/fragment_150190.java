private String getColor(MeshView m, float[] normals) {

    Point3D normal = m.sceneToLocal(0, -1, 0);

    for (int i = 0; i < normals.length; i += 3) {
        if (normals[i] * normal.getX() + normals[i+1] * normal.getY() + normals[i+2] * normal.getZ() > 0.99) {
            return colors[i / 3];
        }
    }
    return "no color found";
}
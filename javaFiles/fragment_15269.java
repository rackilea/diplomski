private Vector3f[] getLimits() {
    Vector3f currentVertex = new Vector3f();

    // Find the limits of the model
    Vector3f[] limit = new Vector3f[2];
    limit[0] = new Vector3f(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
    limit[1] = new Vector3f(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
    for (int i = 0; i < positions.size(); i++) {

        currentVertex = positions.get(i);

        // Keep track of limits for normalization
        if (currentVertex.getX() < limit[0].getX())
            limit[0].setX(currentVertex.getX());
        if (currentVertex.getX() > limit[1].getX())
            limit[1].setX(currentVertex.getX());
        if (currentVertex.getY() < limit[0].getY())
            limit[0].setY(currentVertex.getY());
        if (currentVertex.getY() > limit[1].getY())
            limit[1].setY(currentVertex.getY());
        if (currentVertex.getZ() < limit[0].getZ())
            limit[0].setZ(currentVertex.getZ());
        if (currentVertex.getZ() > limit[1].getZ())
            limit[1].setZ(currentVertex.getZ());
    }
    return limit;
} // End of getLimits
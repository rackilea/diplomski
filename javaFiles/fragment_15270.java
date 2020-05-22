private void normalize() {
    Vector3f[] limits = getLimits();
    for(int i = 0; i < positions.size(); i++) {

        if(positions.get(i).getX() >= 0) {
            positions.get(i).setX(positions.get(i).getX() / limits[1].getX());
        } else {
            positions.get(i).setX(Math.abs(positions.get(i).getX()) / limits[0].getX());
        }

        if(positions.get(i).getY() >= 0) {
            positions.get(i).setY(positions.get(i).getY() / limits[1].getY());
        } else {
            positions.get(i).setY(Math.abs(positions.get(i).getY()) / limits[0].getY());
        }

        if(positions.get(i).getZ() >= 0) {
            positions.get(i).setZ(positions.get(i).getZ() / limits[1].getZ());
        } else {
            positions.get(i).setZ(Math.abs(positions.get(i).getZ()) / limits[0].getZ());
        }
    }
}
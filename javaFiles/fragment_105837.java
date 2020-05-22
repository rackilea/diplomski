class WayPoint {
    String name;
    Pose pose;

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}

class Pose {
    Position position;
    Orientation orientation;
}

class Position {
    double x, y, z;
}

class Orientation {
    double x, y, z, w;
}
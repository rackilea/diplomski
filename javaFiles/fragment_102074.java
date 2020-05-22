public @interface Coordinate {
    public int getDegrees();
    public int getMinutes();
    public double getSeconds();
    public char getDirection();
}

static class Location implements Coordinate {
    @Override
    public int getDegrees() {
        return 0;
    }

    @Override
    public int getMinutes() {
        return 0;
    }

    @Override
    public double getSeconds() {
        return 0;
    }

    @Override
    public char getDirection() {
        return 0;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return Location.class;
    }
}
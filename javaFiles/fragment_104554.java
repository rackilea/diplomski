int setX(Point point) {
    try {
        return this.x;
    } finally {
        this.x = point.x;
    }
}
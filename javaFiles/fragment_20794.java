public void wallXBounceDetect(Figure f) {
        f.setVelocityX(wallBounceDetect(f.getLocationX(), f.getWidth(), canvas.getWidth(), f.getVelocityX()));
    }

    public void wallYBounceDetect(Figure f) {
        f.setVelocityY(wallBounceDetect(f.getLocationY(), f.getHeight(), canvas.getHeight(), f.getVelocityY()));
    }
    public double wallBounceDetect(double location, double size, double maxValue, double velocity) {
        if ((location < 0 && velocity < 0) || (location + size > maxValue && velocity > 0)) {  
            return -velocity;
        }
        return velocity;
    }
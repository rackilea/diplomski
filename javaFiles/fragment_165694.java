/**
     * Shortest distance (angular) between two angles.
     * It will be in range [0, 180].
     */
    public static int distance(int alpha, int beta) {
        int phi = Math.abs(beta - alpha) % 360;       // This is either the distance or 360 - distance
        int distance = phi > 180 ? 360 - phi : phi;
        return distance;
    }
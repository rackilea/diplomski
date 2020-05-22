public void ThreeDimensionalGraph(Location loc, 
               double startX, double startZ, 
               double endX, double endZ, 
               double smoothness,
               DoubleBinaryOperator f) {
    for (double x = startX; x < endX; x += smoothness) {
        for (double z = startZ; z < endZ; z += smoothness) {
            double y = f.applyAsDouble(x, z);
            //drawing
        }
    }
}
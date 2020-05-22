if (vehicleStyle.getVehicleShape().equals(VehicleShape.TRIANGLE)) {
        processingVisualizer
                .fill(vehicleStyle.getColor().red,
                        vehicleStyle.getColor().green,
                        vehicleStyle.getColor().blue);
        processingVisualizer.strokeWeight(1 * vehicleSize);
        //System.out.println(x + "-" + y);

        //## to place face toward movement direction
        /*
         *          -----<|----
         *          |         |
         *         \/         /\
         *          |         |
         *          -----|>----
         */


float x2, y2, x3, y3;
    if (x == 100) {
        System.out.println( "x==100");
        x2 = x - 5;
        y2 = y + 5;
        x3 = x + 5;
        y3 = y + 5;

    } else if (x == 20) {
        System.out.println( "x==20");
        x2 = x - 2;
        y2 = y - 2;
        x3 = x + 2;
        y3 = y - 2;
    } else if (y == 100) {
        System.out.println( "y ==100");
        x2 = x - 2;
        y2 = y - 2;
        x3 = x - 2;
        y3 = y + 2;
    } else if (y == 20) {
        System.out.println( "y ==20");
        x2 = x+5;//x - 2;
        y2 = y-5;
        x3 = x+5 ;//- 2;
        y3 = y+5;
    }
    processingVisualizer.triangle(x, y, x2, y2, x3, y3);
}
processingVisualizer.strokeWeight(1);
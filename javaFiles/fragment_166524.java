public class QuickTester {

    public static void main(String[] args) {

        double [] xyAngles = {0.0, 90.0, 0.0, 45.0};
        double [] xzAngles = {0.0, 0.0, 90.0, 45.0};

        for(int i = 0; i < xyAngles.length; i++)
        {
            double xyAngleRad = Math.toRadians(xyAngles[i]);
            double xzAngleRad = Math.toRadians(xzAngles[i]);

            // To fulfill the 3 conditions mentioned
            double deltaX = Math.cos(xyAngleRad) * Math.cos(xzAngleRad);
            double deltaY = Math.sin(xyAngleRad) * Math.cos(xzAngleRad);
            double deltaZ = Math.cos(xyAngleRad) * Math.sin(xzAngleRad);

            System.out.printf("XY Angle: %4.2f, XZ Angle: %4.2f%n",
                    xyAngles[i], xzAngles[i]);
            System.out.printf("dX: %4.2f, dY: %4.2f, dZ: %4.2f%n%n",
                    deltaX, deltaY, deltaZ);
        }
    }
}
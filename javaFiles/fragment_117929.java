public class Angle {
public static void main(String[] args) {
    int currentAngle = Integer.parseInt(args[0]);
    int targetAngle = Integer.parseInt(args[1]);

    while (currentAngle - targetAngle != 0) {
        if (Math.abs(currentAngle - targetAngle) < 180) {
            // Rotate current directly towards target.
            if (currentAngle < targetAngle) currentAngle++;
            else currentAngle--;
        } else {
            // Rotate the other direction towards target.
            if (currentAngle < targetAngle) currentAngle--;
            else currentAngle++;
        }
        currentAngle = ((currentAngle % 360) + 360) % 360;
        System.out.printf("CurrentAngle = %d, targetAngle = %d\n", 
            currentAngle, targetAngle);
    }

}
}
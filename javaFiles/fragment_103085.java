public class Moo {

final static byte FORWARD = 0x1; // 00000001
final static byte LEFT     =0x2; // 00000010
final static byte RIGHT    =0x4; // 00000100

/**
 * @param args
 */
public static void main(String[] args) {

    byte direction1 = FORWARD|LEFT;  // 00000011
    byte direction2 = FORWARD|RIGHT; // 00000101
    byte direction3 = FORWARD|RIGHT|LEFT; // 00000111

    byte direction4 = 0;

    // someting happens:
    direction4 |= FORWARD;
    // someting happens again.
    direction4 |= LEFT;

    System.out.printf("%x: %s\n", direction1, dirString(direction1));
    System.out.printf("%x: %s\n", direction2, dirString(direction2));
    System.out.printf("%x: %s\n", direction3, dirString(direction3));
    System.out.printf("%x: %s\n", direction4, dirString(direction4));


}

public static String dirString( byte direction) {
    StringBuilder b = new StringBuilder("Going ");

    if( (direction & FORWARD) > 0){
        b.append("forward ");
    }

    if( (direction & RIGHT) > 0){
        b.append("turning right ");
    }
    if( (direction & LEFT) > 0){
        b.append("turning left ");
    }
    if( (direction &( LEFT|RIGHT)) == (LEFT|RIGHT)){
        b.append(" (conflicting)");
    }

    return b.toString();
}

}
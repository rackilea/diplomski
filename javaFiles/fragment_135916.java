/**
 *  Hex distance calculation
 */
public static int distance(int x1, int y1, int x2, int y2) {
    int dx=x2-x1;
    int dy=y2-y1;

    if (dx*dy>0) {
        return Maths.abs(dx)+Maths.abs(dy);
    } else {
        return Maths.max(Maths.abs(dx),Maths.abs(dy));
    }
}
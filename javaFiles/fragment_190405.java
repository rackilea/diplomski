public class XYPos implements Comparable<XYPos> {
    int x;
    int y;

    @Override
    public int compareTo(XYPos o) {
        int res = this.y - o.y;
        if(res == 0) {
            res = this.x - o.x;
        }
        return res;
    }
}
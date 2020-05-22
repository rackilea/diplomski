public class Vec2<This> {

    public This add(double x, double y) {
        this.x += x;
        this.y += y;
        return (This) this;
    }

}

public class Vec3<This> extends Vec2<This> {

    public This add(double x, double y, double z) {
        super.add(x, y);
        this.z  += z;
        return (This) this;
    }
}

public class Vec4<This> extends Vec3<This> {

etc.
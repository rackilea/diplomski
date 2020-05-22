public class SomeObject {

    private String a;
    private char[] b;

    @Override
    public boolean equals(Object anotherObject) {
        if (!(anotherObject instanceof SomeObject)) {
            return false;
        }
        SomeObject object = (SomeObject) anotherObject;
        return (this.a.equals(object.a) && Arrays.equals(this.b, object.b));
    }

    @Override
    public int hashCode() {
        return (43 * this.a.hashCode() + 11 * Arrays.hashCode(this.b));
    }
}
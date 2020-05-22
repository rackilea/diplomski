public class Factory {
    public static I createInstance(Instance i) {
        if (i == Instance.A) {
            return new A();
        } else if (i == Instance.B) {
            return new B();
        } else {
            return null;
        }
    }
}
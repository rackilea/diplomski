public class Outer {

    class Inner {}

    void implicitReferenceToThis() {
        new Inner();
    }

    void explicitReferenceToThis() {
        this.new Inner();
    }

    static void noReferenceToOuter() {
        // new Inner(); // doesnt compile
    }

    static void explictReferenceToOuter() {
        new Outer().new Inner();
    }
}
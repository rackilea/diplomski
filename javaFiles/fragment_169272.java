class UnitType {
    Position myPos;  // This could be private final.

    // Only needed for backwards compatibility if you do new UnitType().
    UnitType() { this(null); }  // this(...) delegates to another constructor.
    // sets the position field.
    UnitType(Position myPos) { this.myPos = myPos; }

    public void getPosition() {
        return myPos;
    }
}
class Unit extends UnitType {
    // No field definition here that masks the super-class one.
    public Unit(Position myPos) {
        super(myPos);  // Invoke UnitType(Position) to set the field
    }
}
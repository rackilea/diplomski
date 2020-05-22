public class AgedA extends A {
    ...
    public int getAge () { return ... }
}

// Then your B and C both extend AgedA, and your ListItem stores an
// AgedA and can use getAge().
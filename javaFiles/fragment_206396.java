public class Atom {
    public final char variable;
    public final bool negated;
    public Atom(char variable, bool negated) {
        this.variable = variable;
        this.negated = negated;
    }
}

public class Minterm {
    public final List<Atom> atoms = new ArrayList<Atom>();
}
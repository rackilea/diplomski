public class PubliclyClonableString implements PubliclyClonable {
    private String s;
    public PubliclyClonableString (String s) {
        this.s = s;
    }

    @Override
    public String clone() {
        return s; // OK, since Strings are immutable
    }

    // getter, setter, etc.
}
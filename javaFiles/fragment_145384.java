public class Partner {
    private final String name;
    private Partner partner;

    public Partner(String name) {
        if (name == null) throw new NullPointerException();
        this.name = name;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner p) {
        // this is critical, or else we'll call each other forever in a loop
        if (partner == p) {
            // we're already partners with p; nothing to do
            return;
        }

        if (partner != null) {
            // already have a partner; tell them we're leaving, directly
            partner.partner = null;  // (we don't want them to call us back)
        }
        partner = p;
        if (p != null) {
            // new partner; let them know about us
            p.setPartner(this);
        }
    }
}
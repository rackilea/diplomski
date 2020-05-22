class TOrganization {

    private String name;

    public TOrganization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof TOrganization) {
            if (((TOrganization) obj).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}

class TRole {

    private TOrganization organization;
    private String name;

    public TRole(TOrganization organization, String name) {
        this.organization = organization;
        this.name = name;
    }

    public TOrganization getOrganization() {
        return organization;
    }

    public String getName() {
        return name;
    }

}

public static void main(String[] args) {
    Set<TOrganization> organizations = new LinkedHashSet<TOrganization>();
    Set<TRole> roles = new LinkedHashSet<TRole>();
    StringBuilder message = new StringBuilder("Requested roles: " + "\n");

    TOrganization orga = new TOrganization("Test org A");
    TOrganization orgb = new TOrganization("Test org B");

    organizations.add(new TOrganization("Test org A"));
    organizations.add(new TOrganization("Test org B"));
    roles.add(new TRole(orga, "Test Role A 1"));
    roles.add(new TRole(orga, "Test Role A 2"));
    roles.add(new TRole(orgb, "Test Role B 1"));
    roles.add(new TRole(orgb, "Test Role B 2"));

    for (TOrganization org : organizations) {
        message.append(" - " + org.getName() + "\n");
        for (TRole role : roles) {
            if (role.getOrganization().equals(org)) {
                message.append("   - " + role.getName() + "\n");
            }
        }
    }
    System.out.println(message.toString());
}
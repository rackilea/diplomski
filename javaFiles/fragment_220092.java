...
private String manager;
private transient boolean managing;

...
public boolean isManaging {
    return "Y".equals(manager);
}

public void setManaging(boolean managing) {
    this.managing = managing;
    this.manager = managing ? "Y" : "N";
}
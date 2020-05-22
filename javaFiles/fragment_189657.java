@Transient
public String getid() {
    return tta.getMyIds().getId();
}

public void setid(String id) {
    this.tta.getMyIds().setId(id);
}
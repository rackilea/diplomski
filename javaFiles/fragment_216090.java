@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "client")
public Set<Posto> getPosti() {
    return posti;
}

public void setPosti(Set<Posto> posti) {
    this.posti = posti;
}

@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "client")
public Set<Luce> getLuci() {
    return luci;
}

public void setLuci(Set<Luce> luci) {
    this.luci = luci;
}
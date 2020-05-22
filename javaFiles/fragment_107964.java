@Access(AccessType.FIELD)
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Site> sites = new ArrayList<Site>();


@Transient
public List<Site> getSites() {
        return sites;
}
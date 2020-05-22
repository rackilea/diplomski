private List<Site> sites = new ArrayList<Site>();

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
public List<Site> getSites() {
        return sites;
}
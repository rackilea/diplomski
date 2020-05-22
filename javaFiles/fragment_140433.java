public Route(Route r) {
    List<Site> newSites = new ArrayList<Site>();

    for (Site obj: r.sites) {
        // Add copy of obj to the newSites
        // So you need yet another copy constructor in 'Site' class.
    }

    this.sites = newSites;
}
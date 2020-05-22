@OneToMany(fetch = FetchType.LAZY, mappedBy = "mods", cascade = {CascadeType.ALL})  
    @OrderBy("ReleaseDate desc")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE) 
    public Set<ModVersion> getModsVersionses() {
        return this.modsVersionses;
    }
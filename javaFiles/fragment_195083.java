@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "idsensor", referencedColumnName = "idsensor"),
        @JoinColumn(name = "date", referencedColumnName = "date"),
        @JoinColumn(name = "event_time", referencedColumnName = "event_time")
})
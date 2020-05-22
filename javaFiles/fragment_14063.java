@OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="targeted_universities",
            joinColumns = @JoinColumn( name="targeted_gift_id"),
            inverseJoinColumns = @JoinColumn( name="university_id")
    )
    private List<DatabaseUniversity> universities;
@OneToMany
@JoinTable(
        name="table_name",
        joinColumns = @JoinColumn( name="columnname")
)
private Set<TransitionAction> tacts;
@ManyToOne(optional = true)
@JoinColumn(name = "parent_id")
public Setting parent;

@OneToMany(fetch = FetchType.EAGER, mappedBy = "parent" , cascade = {CascadeType.ALL})
public Collection<Setting> children;
@XmlTransient
@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "USER_ID")
private Users user;

@OneToMany(
        mappedBy = "device",
        fetch = FetchType.EAGER,
        cascade = {CascadeType.REMOVE, CascadeType.MERGE,CascadeType.PERSIST})
private List<Remotes> remotes;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "examination", fetch = FetchType.LAZY)
public Set<Question> questions = new HashSet<Question>();

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "specialQuestion")
public Question specialQuestion;
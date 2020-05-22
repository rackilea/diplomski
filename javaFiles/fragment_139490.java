@OneToMany(fetch = FetchType.EAGER)
@JoinColumn(name = "X", referencedColumnName = "X", insertable = false, updatable = false)
@NotFound(action = NotFoundAction.IGNORE)
@Fetch(FetchMode.SELECT)
private Set<MyType> siblings;

public Map<String,List<MyType>> getSiblings() {
   ... do the grouping manually in Java ...
}
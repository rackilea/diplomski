@ElementCollection
 @CollectionTable(
    name="project_branches",
    joinColumns=@JoinColumn(name="branches"),
    uniqueConstraints = {@UniqueConstraint(columnNames={"project_id", "branches"})}
  )
  Set<String> branches;
@ElementCollection
@CollectionTable(name = "map__company__branches",
    joinColumns = @JoinColumn(name = "company_id"))
@MapKeyJoinColumn(name = "branch_id")
@Column(name = "is_primary_branch")
Map<Branch, Boolean> branchMap;
@JoinTable(name = "PARENT_CHILD", 
    joinColumns = @JoinColumn(name = "PARENT_ID"), 
    foreignKey = @ForeignKey(name ="FK_PARENT_CHILD_PARENT"), 
    inverseJoinColumns = @JoinColumn(name = "CHILD_ID"), 
    inverseForeignKey = @ForeignKey(name ="FK_ABC"), 
    uniqueConstraints = {@UniqueConstraint(columnNames = "CHILD_ID", name = "UK_CHILD_ID") })
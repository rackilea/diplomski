@ManyToMany(cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE,
    CascadeType.DELETE
})
@JoinTable(name = "EMP_DEPT",
    joinColumns = @JoinColumn(name = "emp_id"),
    inverseJoinColumns = @JoinColumn(name = "dept_id")
)
private List<Emp> emps= new ArrayList<>();
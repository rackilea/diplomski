class Task {

    private Long id;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "task_incharge", joinColumns = { @JoinColumn(name = "task_id",  referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "person_id", referencedColumnName = "id") })    
    private Set<Person> personsInCharge;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "task_contributors", joinColumns = { @JoinColumn(name = "task_id",  referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "person_id", referencedColumnName = "id") })    
    private Set<Person> contributors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "task_validators", joinColumns = { @JoinColumn(name = "task_id",  referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "person_id", referencedColumnName = "id") })  
    private Set<Person> validators;

}
@JoinTable(
        name = "MY_JT",
        joinColumns = @JoinColumn(
                name = "PROJ_ID",
                referencedColumnName = "PID"
        ),
        inverseJoinColumns = @JoinColumn(
                name = "TASK_ID",
                referencedColumnName = "TID"
        )
)
@OneToMany
private List<Task> tasks;
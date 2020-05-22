@Entity
class Person {

    @ManyToMany
    @JoinTable(name="PERSON_ACTIVITY",
            joinColumns=@JoinColumn(name="PERSON_ID"),
            inverseJoinColumns=@JoinColumn(name="ACTIVITY_ID"))
    @WhereJoinTable(clause = "hobby = 1")
    Set<Activity>  hobbyActivities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="PERSON_ACTIVITY",
            joinColumns=@JoinColumn(name="PERSON_ID"),
            inverseJoinColumns=@JoinColumn(name="ACTIVITY_ID"))
    @WhereJoinTable(clause = "duty = 1")
    Set<Activity>  dutyActivities;

}
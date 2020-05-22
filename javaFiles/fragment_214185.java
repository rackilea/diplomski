@Entity
class Activity{

    @ManyToMany
    @JoinTable(name="PERSON_ACTIVITY",
            joinColumns=@JoinColumn(name="ACTIVITY_ID"),
            inverseJoinColumns=@JoinColumn(name="PERSON_ID"))
    @WhereJoinTable(clause = "hobby = 1")
    Set<Person>  hobbyPeople;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="PERSON_ACTIVITY",
            joinColumns=@JoinColumn(name="ACTIVITY_ID"),
            inverseJoinColumns=@JoinColumn(name="PERSON_ID"))
    @WhereJoinTable(clause = "duty = 1")
    Set<Person>  dutyPeople;
}
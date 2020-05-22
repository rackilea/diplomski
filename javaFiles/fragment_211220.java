public class Course implements Item, Serializable {

    ...

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, targetEntity = Activity.class, orphanRemoval = true, cascade = CascadeType.REMOVE )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Activity> activities;

    ...

}
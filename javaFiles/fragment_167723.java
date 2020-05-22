@Entity
public class Schedule implements Serializable {
....
    @OneToMany
    @MapKey(name = "theDate")
    private Map<LocalDate, ListOfLessons> allLessons = new HashMap<>();
....
}
@Entity
public class ListOfLessons implements Serializable {
...
    private LocalDate theDate;
    @OneToMany
    private List<Lesson> allLessons = new ArrayList<>();
...
}
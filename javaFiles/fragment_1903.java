@Entity
@Table(name = "TASK_XREF")
class Task {
    @EmbeddedId
    TaskPKId taskPKId;

    @Column(name = "TASK_NAME")
    String name;
    @MapsId("storyId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STORY_ID")
    Story story;

    //getters, setters

}
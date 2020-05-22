@Entity
public class Quiz {

    private SimpleStringProperty name = new SimpleStringProperty();

    private int quiz_id;

    private List<Task> taskList;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name="teacher_id", nullable = false)
    private Teacher owner;

    public Quiz() {
    }

    public Quiz(String name, Teacher owner) {
        this.name.set(name);
        this.owner = owner;
        taskList = new ArrayList<>();
    }

    public Quiz(String name, Teacher owner, List<Task> taskList) {
        this.name.set(name);
        this.owner = owner;
        this.taskList = taskList;
    }

    @Column(nullable = false)
    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Teacher getOwner() {
        return owner;
    }

    public void setOwner(Teacher owner) {
        this.owner = owner;
    }

    @Id
    @GenericGenerator(name="id" , strategy="increment")
    @GeneratedValue(generator="id")
    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    @OneToMany
    public List<Task> getTasksList() {
        return taskList;
    }

    public void setTasksList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
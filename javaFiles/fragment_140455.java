@Entity
public class Teacher extends User{

    private List<Quiz> quizList;

    public Teacher() {
    }

    public Teacher(String name, String surname, String nick, String password) {
        super(name, surname, nick, password);
        quizList = new ArrayList<>();
    }

    @OneToMany(mappedBy = "teacher")
    @Cascade(CascadeType.ALL)
    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }
}
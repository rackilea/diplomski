@Embedabble               // or @Entity if you want to use @OneToMany in TodoListUser
public class Task {
@Id
@GeneratedValue
private Integer id;

private String title;
private String text;
private boolean done;
}
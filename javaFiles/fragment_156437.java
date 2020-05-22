@Entity
@NoArgsConstructor
@Getter 
@Setter 
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private Boolean isDone = Boolean.FALSE;

    public Task(int id, String text){
        this.id = id;
        this.text = text;
        this.isDone = Boolean.FALSE;
    }
}
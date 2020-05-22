@Entity
public class App implements Serializable {

    @Id
    private int id;

    @Column(name="app_id")
    private String appId;
}
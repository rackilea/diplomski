@Entity
@Table(name = "chat_bot")
public class Bot {

    @Id
    private String id;

    @OneToMany(mappedBy = "bot", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BotVersion> versions = new LinkedHashSet<>();

}
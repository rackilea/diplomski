@Entity
@Table(name = "chat_bot_version")
@IdClass(BotVersionPK.class)
public class BotVersion {

    @Id
    private String botId;
    @Id
    private int version;

    @ManyToOne
    @JoinColumn(name = "botId", insertable=false, updatable=false)
    private Bot bot;

    @Type(type = "text")
    private String json;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "botVersion")
    private Set<BotEnvironments> environments = new LinkedHashSet<>();

}
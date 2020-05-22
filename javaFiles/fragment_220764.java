@Entity
@Table(name = "chat_bot_environments")
@IdClass(BotEnvironmentsPK.class)
public class BotEnvironments {
    @Id
    private String botId;
    @Id
    private int version;
    @Id
    private String environmentCode;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "botId", referencedColumnName = "botId", insertable=false, updatable=false),
            @JoinColumn(name = "version", referencedColumnName = "version", insertable=false, updatable=false)
    })
    private BotVersion botVersion;

}
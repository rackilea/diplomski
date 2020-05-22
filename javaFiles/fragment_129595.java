import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

@Named
@ConversationScoped
public class SimpleBean implements Serializable {

    @Inject
    private Conversation conversation;

    @PostConstruct
    public void init() {
        conversation.begin();
    }

    public String navigateToOtherPage() {
        conversation.end();
        return "otherPage?faces-redirect=true";
    }

    // ...
}
@Named
@ConversationScoped
public class RepositoryBean extends AbstractViewBean<Repository> {
    // Various properties etc. here

    @In
    Conversation conversation

    private Long customerId;

    public void init() {
        log.info("Customer ID is "+ customerId);
        conversation.begin();
    }
}
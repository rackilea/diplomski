@DefaultProperty("interactions")
public class AppMenuItem extends MenuItem {

    private final ListProperty<InteractionDefintion> interactions = new SimpleListProperty<>(this, "interactions");

    public final void setInteractions(ObservableList<InteractionDefinition> interactions) {
        this.interactions.set(interactions);
    }

    public final ObservableList<InteractionDefinition> getInteractions() {
        return interactions.get();
    }

    public final ListProperty<InteractionDefinition> interactionsProperty() {
        return interactions;
    }

}
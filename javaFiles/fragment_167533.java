@Named
@ViewScoped
public class ShuffleBackingBean implements Serializable {
    public void onShuffle(ComponentSystemEvent event) {
        final List<UIComponent> components = new ArrayList<>(event.getComponent().getChildren());
        Collections.shuffle(components);

        event.getComponent().getChildren().clear();
        event.getComponent().getChildren().addAll(components);  
    }
}
public class RuleController  extends SelectorComposer<Component> {

    ...

    Image imageTemp = (Image)image.clone();

    EventListener<Event> actionListener = new SerializableEventListener<Event>() {
        private static final long serialVersionUID = 1L;

        public void onEvent(Event event) throws Exception {
            delCondition1(indexCon1);
        }
    };

    imageTemp.addEventListener(Events.ON_CLICK, actionListener);

    ...

    public void delCondition1(int index){
        ...
    }
}
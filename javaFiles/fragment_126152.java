public class SwitchableIdModule extends SimpleModule {

    private static final long serialVersionUID = 1L;


    public SwitchableIdModule() {
        addKeySerializer(SwitchableId.class, new SwitchableIdSerializer());
        addKeyDeserializer(SwitchableId.class, new SwitchableIdDeserializer());
    }
}
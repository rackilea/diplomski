public class Widget {
    @Mapped(key = "WDGT_ID", defaultValue = "")
    private String id;
    @Mapped(key = "WDGT_NAME", defaultValue = "")
    private String name;
    @Mapped(key = "WDGT_DESC", defaultValue = "")
    private String description;

    [constructors...]
    [getters&setters...]
}
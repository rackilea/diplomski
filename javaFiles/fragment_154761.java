@ManagedProperty(value="#{param.length}")
private int length;

@PostConstruct
public void init() {
    this.tags = new String[length];
}
public class ContainerEntity {
    @Id
    String id;
    @Index
    private Map<String, String> properties = new HashMap<>();
}
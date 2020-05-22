@Local
public interface LocalBeanLocal {
    // Implementation omitted
}

@Stateless(name = "LocalBean")
public class LocalBean implements LocalBeanLocal {
    // Implementation omitted
}
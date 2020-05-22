@Component
public class DomainA {
    @Autowired
    private ApplicationContext context;
    public boolean isContextInitilized() {
        return context != null;
    }
}
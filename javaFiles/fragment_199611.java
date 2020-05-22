@Component(value = "monitoring")
@Log4j2
class Monitoring {

    @Value("${caching.disable.users:#{T(java.util.Collections).emptyList()}}")
    private List<String> users;

    public boolean monitoringUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        // do not cache
        if (users.contains(name)) return true;

        return false;
    }
}
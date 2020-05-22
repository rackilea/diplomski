@ConfigurationProperties(prefix = "properties", locations = "classpath:sports.yml")
public class SportsProperties {

    private Map<SportsEnum, List<TeamsEnum>> sports;
    private Map<SportsEnum, Map<SportSettingsEnum, String>> settings;

    public Map<SportsEnum, List<TeamsEnum>> getSports() {
        return sports;
    }

    public void setSports(Map<SportsEnum, List<TeamsEnum>> sports) {
        this.sports = sports;
    }

    public Map<SportsEnum, Map<SportSettingsEnum, String>> getSettings() {
        return settings;
    }

    public void setSettings(
        Map<SportsEnum, Map<SportSettingsEnum, String>> settings) {
        this.settings = settings;
    }

    @PostConstruct
    public void customManipulation() {
        System.out.println(sports);
        System.out.println(settings);
    }
}
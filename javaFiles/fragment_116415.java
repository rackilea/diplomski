public class JedisMock {

    private String host;

    public JedisMock(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    // method to mock your method
    public String get(String text) {
        double randomValue = Math.random();
        if (randomValue < 0.333) {
            return "1";
        } else if (randomValue < 0.667) {
            return "e";
        } else {
            return "";
        }
    }
}
import java.util.ServiceLoader;

public class BotResolver {

    private final ServiceLoader<Bot> loader;

    public BotResolver() {
        loader = ServiceLoader.load(Bot.class);
    }

    /**
     * Gets all bot implementations that are currently available in the classpath.
     */
    public List<Bot> getAllBots() {

        List<Bot> allBots = new ArrayList<>();
        Iterator<Bot> it = loader.iterator();

        while (it.hasNext()) {
           allBots.add(it.next());
        }

        return allBots;
    }
}
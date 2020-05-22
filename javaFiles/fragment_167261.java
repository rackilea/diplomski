public class botGame{
    Map<String, Bot> bots = new Map<String, Bot>();

    public void makeNewBot(String name) {
        bots.put(name, new(Bot(name)));
    }

    public void startBot(String name) {
        bots.get(name).run();  // TODO: Add check for wrong name
    }

    public void stopBot(String name) {
        bots.get(name).stop(); // TODO: Add check for wrong name
    }
}
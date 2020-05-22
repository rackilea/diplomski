public class Log {
    private static Updatable console = Updatables.getUpdatable();

    private static void consoleOut(String data) {
        System.out.println(data);
        console.update(data);
    }

    public static void level0(String data) {
        if (Status.ConsoleLevel >= 0) {
            consoleOut(data);
        }
    }
}
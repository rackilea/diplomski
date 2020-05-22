public class InfoboardManager {
private MainInfoboard mi;
private Player p;

public InfoboardManager(Player p) {
    this.p = p;
    this.mi = new MainInfoboard();
}

public MainInfoboard getMainInfoboard() {
    return mi;
}

public class MainInfoboard {
    public void echoName() {
        System.out.println("His name is " + p.getName());
    }
}
}
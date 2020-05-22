public class Adv_Settings {
        private Text text;
        public static String urls = new String("http://arsenovic.host56.com/tent.schematic");
        public String jar_url = new String("http://dev.bukkit.org/bukkit-plugins/tentmod/files/");
        private Text text_1;
         ...
    }
public class TMInstaller {

    protected Shell shlTentmodInstaller;
    private Text txtInstallerHasStarted;

protected void createContents() {
        .....
        URL url = new URL(Adv_Settings.urls);

}
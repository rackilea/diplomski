public class Check extends SwingWorker<String, String> {

    private JTextArea estado;   
    Private JTextField updatedVersion;
    private JLabel updatedLabel;
    private String catchUpdatedVersion;
    int UPDATENUMBER;
    int CURRENTNUMBER;

    public Check(JTextArea estado, JTextField updatedVersion, JLabel updatedLabel) {
        this.estado = estado;
        this.updatedVersion = updatedVersion;
        this.updatedLabel = updatedLabel;
    }

    protected void process(List<String> values) {
        for (String value : values) {
            estado.append(value);
        }
    }

    protected String doInBackground() throws Exception {
        String infURL = "https://thread.googlecode.com/svn/trunk/thread.inf";
        String name = "thread.inf";
        File file = new File(name);

        URLConnection conn = new URL(infURL).openConnection();
        conn.connect();
        publish("Conectando al servidor...");
        publish(System.getProperty("line.separator"));
        publish(" -- Buscando actualizaciones... --");
        publish(System.getProperty("line.separator"));
        /*...*/          
    }
}
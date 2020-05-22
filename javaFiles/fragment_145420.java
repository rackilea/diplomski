public class Pinger {

    protected Process process;

    /**
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final Pinger pinger = new Pinger(); // Pinger must be final for access by anonymous class below
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                frame.setSize(300, 400);
                frame.add(panel);
                JTextArea textArea = new JTextArea();

                // Create the stop button and handle the client event
                JButton stop = new JButton();
                stop.setText("Stop");
                stop.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent arg0) {
                        try {
                            pinger.process.destroy();
                        } catch (Exception e){}                        
                    }
                    public void mouseReleased(MouseEvent arg0) {}
                    public void mousePressed(MouseEvent arg0) {}
                    public void mouseExited(MouseEvent arg0) {}
                    public void mouseEntered(MouseEvent arg0) {}
                });
                panel.add(stop);
                panel.add(textArea);


                frame.setVisible(true);
                pinger.executor.execute(pinger.createRunnable("google.com",
                        textArea));
            }
        });

    }

    private Runnable createRunnable(final String ip, final JTextArea area) {
        return new Runnable() {
            public void run() {
            String resposta = "";
            String comando = "ping -t " + ip;

            try {
                // assign the new process object to your instance variable
                process = Runtime.getRuntime().exec(comando);
                Scanner S = new Scanner(process.getInputStream());
                while (S.hasNextLine()) {
                    final String newText = S.nextLine();
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            area.setText(area.getText()
                                    + System.getProperty("line.separator")
                                    + newText);
                        }
                    });

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    };
}

Executor executor = Executors.newFixedThreadPool(1);

}
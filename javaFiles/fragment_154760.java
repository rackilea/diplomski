public class Network {

    Visualiser visualiser;
    Network() throws InterruptedException {

        visualiser = new Visualiser();
        JFrame graph = new JFrame();
        graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graph.setLocation(new Point(150,150));
        graph.getContentPane().add(visualiser);
        graph.pack();
        graph.setVisible(true);
        new VisulizerUpdateTask().execute();
    }

    //use swing worker perform long task
    class VisulizerUpdateTask extends SwingWorker<Void,Void> {

        @Override
        public Void doInBackground() {
            for(int i = 0; i < 100; i++) {
                visualiser.setText(String.valueOf(i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) { ex.printStackTrace();   }
                visualiser.repaint();
            }
            return null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame settings = new JFrame();
        settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings.add(new JLabel("settings"));
        new Network();
        settings.pack();
        settings.setVisible(true);
    }
}
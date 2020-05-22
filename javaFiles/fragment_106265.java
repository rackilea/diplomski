public class PipePanel extends JPanel {
    List<PipeObject> pipes = new ArrayList<PipeObject>();

    public PipePanel() {
        pipes.add(new PipeObject(100, 90));
        pipes.add(new PipeObject(300, 290));
        pipes.add(new PipeObject(500, 490));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for ( PipeObject pipe : pipes ){
            pipe.drawPipe(g);
        }
    }
}
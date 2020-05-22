public class gamePanel extends JPanel{
    private ButtonsPanel buttonsPanel;
    private GraphicsPanel graphicsPanel;

    public gamePanel(){
        super();
        this._initGUI();
    }
    private void _initGUI(){
        this.buttonsPanel = new ButtonsPanel();
        this.graphicsPanel = new GraphicsPanel();

        this.setLayout(new BorderLayout());
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(graphicsPanel, BorderLayout.CENTER);
    }

    public void run(){
        graphicsPanel.run();
    }
}

public class GraphicsPanel extends JPanel(){

    public void run(){
        // this method could be called from the game loop.

        // ....
        // ....

        this.repaint();
    }

    @Override
    public void paint(Graphics g){
        // here paint all graphics
    }
}

public class ButtonsPanel extends JPanel{
    public ButtonsPanel(){
        super();
        this._initGUI();
    }

    private void _initGUI(){
        // here add all the buttons you want..
    }
}
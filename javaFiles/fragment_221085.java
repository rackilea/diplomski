// don't like class name of Window as this name shadows an important
// core Java Swing class.
public class Window extends JPanel implements IObserver, ActionListener{
    private Timer timer = new Timer(5, this);
    private GameWorldProxy gwp;

    public Window(){
        super.setBorder(BorderFactory.createTitledBorder("Window:"));
        timer.start();
    }
    public void update(IObservable o, Object arg){
        gwp = (GameWorldProxy) o;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (GameObject gameObject : gwp.getCollection()) {
          gameObject.draw(g); // may need x and y here, but not sure where this data is held
        }        
    }
    public void actionPerformed(ActionEvent e){
      // some method to move components here
      repaint();
    }
}
public class Controller {

    private Model m; //class Model not shown
    private Viewer v; //class Viewer not shown
    private JFrame frame;
    private ControlPanelOne cpo;
    private ControlPanelTwo cpt; //class ControlPanelTwo not shown

    public Controller() {
        m = new Model();
        v = new Viewer();
        frame = new JFrame();
        frame.setLayeredPane(null); // Do something

        cpo = new ControlPanelOne(this); // Supply self to the instance of ControlPanelOne
        cpt = new ControlPanelTwo();

        frame.add(cpo.getPanel());
        frame.add(cpt.getPanel());
    }

    public void update() {
        m.update();
        v.update();
    }
}
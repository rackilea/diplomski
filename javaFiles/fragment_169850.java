public class MVCOutline {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            //@Override
            public void run() {
                new MVCOutline().create();
            }
        });
    }

    private void create() {
        JFrame f = new JFrame("MVC Outline");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MainPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class MainPanel extends JPanel {

    public MainPanel() {
        super(new BorderLayout());
        Model model = new Model();
        View view = new View(model);
        Control  control = new Control(model, view);
        this.add(view, BorderLayout.CENTER);
        this.add(control, BorderLayout.WEST);
    }
}

class Control extends JPanel implements ... {

    private Model model;
    private View view;

    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
    }
}

class View extends JPanel implements Observer {

    private Model model;

    public View(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        // update GUI based on model
    }
}

class Model extends Observable {

    public void next() {
        this.notifyObservers(...);
    }
}
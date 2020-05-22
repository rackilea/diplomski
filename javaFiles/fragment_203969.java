public interface SwapInterface {
    public void swapView(String view);
}

public Frame extends JFrame implements SwapInterface {
    MainMenu mainPanel = new MainMenu(Frame.this);
    ....
    @Override
    public void swapView(String view) {
        cl.show(getContentPane(), view);
    }
}

public class MainMenu extends JPanel {
    private SwapInterface swap;

    public MainMenu(SwapInterface swap) {
        this.swap = swap;
        ...
        public void actionPerfomed(ActionEvent e) {
            swap.swapView("single");
        }

    }
}
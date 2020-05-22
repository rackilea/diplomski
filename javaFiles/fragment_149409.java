import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class HideButtonGui
{
    private JFrame myFrame;
    private PanelWithButtons comp;

    public HideButtonGui() {
        setupGui();
    }

    private void setupGui() {
        myFrame = new JFrame();
        comp = new PanelWithButtons();

        myFrame.getContentPane().add(comp.getPanel());
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        HideButtonGui gui = new HideButtonGui();
        gui.go();
    }

    public void go() {
        SwingUtilities.invokeLater(() -> myFrame.setVisible(true));

        try {
            TimeUnit.SECONDS.sleep(5);

            /*
                This is me calling a function from another class.
                That function hides the buttons.
                Notice that all interaction with GUI elements is done
                in the Event Dispatch Thread.
            */
            SwingUtilities.invokeLater(() -> comp.hideButtons());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class PanelWithButtons {
    private JButton drawBtn;
    private JButton pickBtn;
    private JPanel myPanel;

    private int count = 0;

    public PanelWithButtons() {
        setupGui();
    }

    private void setupGui() {
        drawBtn = new JButton("Draw");
        pickBtn = new JButton("Pick");

        myPanel = new JPanel();
        myPanel.add(drawBtn);
        myPanel.add(pickBtn);

        drawBtn.addActionListener(evt -> hideButtonClicked());
        pickBtn.addActionListener(evt -> pickButtonClicked());
    }

    private void pickButtonClicked() {
        hideButtons();
        count = 1;
        System.out.println(count);
    }

    private void hideButtonClicked() {
        hideButtons();
        count = 0;
        System.out.println(count);
    }

    public void hideButtons() {
        drawBtn.setVisible(false);
        pickBtn.setVisible(false);
    }

    public void showButtons() {
        drawBtn.setVisible(true);
        pickBtn.setVisible(true);
    }


    public JPanel getPanel() {
        return myPanel;
    }
}
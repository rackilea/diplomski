import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    private static final long serialVersionUID = -5151041547543472432L;

    public GameFrame() {
        super("Clash101");

        setSize(1000, 1000);
        setLayout(new FlowLayout());
        // setFocusable(true);
    }
}
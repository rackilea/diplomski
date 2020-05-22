import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

    private JButton btnSinglePlayer, btnMultiPlayer;

    public MainMenu() {
        setLayout(null);

        btnSinglePlayer = new JButton("singlePlayer");
        btnSinglePlayer.setBounds(320, 25, 275, 130);
        add(btnSinglePlayer);
        btnSinglePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireStartSinglePlayer();
            }
        });

        btnMultiPlayer = new JButton("MultiPlayer");
        btnMultiPlayer.setBounds(320, 170, 275, 130);
        add(btnMultiPlayer);
        btnMultiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireStartMultiPlayer();
            }
        });

    }

    public void addMainMenuListener(MainMenuListener listener) {
        listenerList.add(MainMenuListener.class, listener);
    }

    public void removeMainMenuListener(MainMenuListener listener) {
        listenerList.remove(MainMenuListener.class, listener);
    }

    public void fireStartSinglePlayer() {
        MainMenuListener[] listeners = listenerList.getListeners(MainMenuListener.class);
        if (listeners != null && listeners.length > 0) {
            for (MainMenuListener listener : listeners) {
                listener.startSinglePlayer();
            }
        }
    }

    public void fireStartMultiPlayer() {
        MainMenuListener[] listeners = listenerList.getListeners(MainMenuListener.class);
        if (listeners != null && listeners.length > 0) {
            for (MainMenuListener listener : listeners) {
                listener.startMultiPlayer();
            }
        }
    }

    public interface MainMenuListener extends EventListener {

        public void startSinglePlayer();
        public void startMultiPlayer();

    }

}
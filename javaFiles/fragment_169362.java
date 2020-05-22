import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerHome implements ActionListener {

    private GUI gui;

    public ListenerHome(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.registrieren) {
            gui.label.setVisible(false);
            gui.username_bezeichnung.setVisible(true);
            gui.vorname_bezeichnung.setVisible(true);
            gui.nachname_bezeichnung.setVisible(true);
            gui.geburtstag_bezeichnung.setVisible(true);
            gui.email_bezeichnung.setVisible(true);
            gui.passwort_bezeichnung.setVisible(true);
            gui.registrieren.setVisible(false);
            gui.login.setVisible(false);
            gui.registrierenBestätigen.setVisible(true);
            gui.username.setVisible(true);
            gui.vorname.setVisible(true);
            gui.nachname.setVisible(true);
            gui.email.setVisible(true);
            gui.geburtstag.setVisible(true);
            gui.passwort.setVisible(true);

        }
    }
}
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ListenerRegistrieren implements ActionListener {

    private GUI gui;

    public ListenerRegistrieren(GUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.registrierenBestätigen) {
            addBenutzer();
        }
    }

    private void addBenutzer() {

        try {

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:MSAccess");
            PreparedStatement pstm;
            String sql = "Insert Into Benutzer ('Benutername', 'Vorname', 'Nachname', 'E-Mail') values ('?','?','?','?')";
            pstm = conn.prepareStatement(sql);

            // SQL Statements
            pstm.setString(1, gui.username.getText());
            pstm.setString(2, gui.vorname.getText());
            pstm.setString(3, gui.nachname.getText());
            pstm.setString(4, gui.email.getText());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
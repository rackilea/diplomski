import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI {

    JFrame frame;
    JPanel panel;
    JLabel label;
    JLabel username_bezeichnung;
    JLabel vorname_bezeichnung;
    JLabel nachname_bezeichnung;
    JLabel geburtstag_bezeichnung;
    JLabel email_bezeichnung;
    JLabel passwort_bezeichnung;
    JButton registrieren;
    JButton login;
    JButton registrierenBestätigen;
    JTextField username;
    JTextField vorname;
    JTextField nachname;
    JTextField email;
    JFormattedTextField geburtstag;
    JPasswordField passwort;

    public GUI() {

        ListenerHome h = new ListenerHome(this);
        ListenerRegistrieren r = new ListenerRegistrieren(this);

        /**
         * Frames
         */
        // Frame Main
        frame = new JFrame("Main");
        frame.setSize(800, 600);
        frame.setLocation(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        /**
         * Panels
         */
        // Panel Main
        panel = new JPanel();
        panel.setSize(780, 475);
        panel.setLayout(null);
        frame.add(panel);

        /**
         * Labels
         */
        // Label Main
        label = new JLabel();
        label.setSize(200, 300);
        label.setLocation(230, 30);
        label.setVisible(true);
        label.setText("Guten Tag, was m�chten Sie tun?");
        panel.add(label);

        // Label Username
        username_bezeichnung = new JLabel();
        username_bezeichnung.setBounds(65, 50, 120, 30);
        username_bezeichnung.setVisible(false);
        username_bezeichnung.setText("Username");
        panel.add(username_bezeichnung);

        // Label Vorname
        vorname_bezeichnung = new JLabel();
        vorname_bezeichnung.setBounds(65, 90, 120, 30);
        vorname_bezeichnung.setVisible(false);
        vorname_bezeichnung.setText("Vorname");
        panel.add(vorname_bezeichnung);

        // Label Nachname
        nachname_bezeichnung = new JLabel();
        nachname_bezeichnung.setBounds(65, 130, 120, 30);
        nachname_bezeichnung.setVisible(false);
        nachname_bezeichnung.setText("Nachname");
        panel.add(nachname_bezeichnung);

        // Label Geburtstag
        geburtstag_bezeichnung = new JLabel();
        geburtstag_bezeichnung.setBounds(390, 50, 120, 30);
        geburtstag_bezeichnung.setVisible(false);
        geburtstag_bezeichnung.setText("Geburtstag");
        panel.add(geburtstag_bezeichnung);

        // Label E-Mail
        email_bezeichnung = new JLabel();
        email_bezeichnung.setBounds(390, 90, 120, 30);
        email_bezeichnung.setVisible(false);
        email_bezeichnung.setText("E-Mail");
        panel.add(email_bezeichnung);

        // Label Passwort
        passwort_bezeichnung = new JLabel();
        passwort_bezeichnung.setBounds(390, 130, 120, 30);
        passwort_bezeichnung.setVisible(false);
        passwort_bezeichnung.setText("Passwort");
        panel.add(passwort_bezeichnung);

        /**
         * Buttons
         */
        // Button registrieren
        registrieren = new JButton("Registrieren");
        registrieren.setLocation(200, 320);
        registrieren.setSize(120, 50);
        registrieren.setVisible(true);
        registrieren.addActionListener(h);
        panel.add(registrieren);

        // Button login
        login = new JButton("Login");
        login.setLocation(350, 320);
        login.setSize(120, 50);
        login.setVisible(true);
        login.addActionListener(h);
        panel.add(login);

        // Button registrieren best�tigen
        registrierenBestätigen = new JButton("Registrieren");
        registrierenBestätigen.setLocation(390, 350);
        registrierenBestätigen.setSize(120, 50);
        registrierenBestätigen.setVisible(false);
        registrierenBestätigen.addActionListener(r);
        panel.add(registrierenBestätigen);

        /**
         * Textfields
         */
        // Textfield Username
        username = new JTextField("", 20);
        username.setBounds(150, 50, 120, 30);
        username.setVisible(false);
        panel.add(username);

        // Textfield Vorname
        vorname = new JTextField("", 20);
        vorname.setBounds(150, 90, 120, 30);
        vorname.setVisible(false);
        panel.add(vorname);

        // Textfield Nachname
        nachname = new JTextField("", 20);
        nachname.setBounds(150, 130, 120, 30);
        nachname.setVisible(false);
        panel.add(nachname);

        // Textfield Geburtstag
        geburtstag = new JFormattedTextField(new SimpleDateFormat("dd.MM.yyyy"));
        geburtstag.setValue(new java.util.Date());
        geburtstag.setBounds(475, 90, 120, 30);
        geburtstag.setVisible(false);
        panel.add(geburtstag);

        // Textfield E-Mail
        email = new JTextField("", 25);
        email.setBounds(475, 50, 120, 30);
        email.setVisible(false);
        panel.add(email);

        // Passwortfield Passwort
        passwort = new JPasswordField("", 20);
        passwort.setBounds(475, 130, 120, 30);
        passwort.setVisible(false);
        panel.add(passwort);

    }
}
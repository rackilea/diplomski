import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.image.*;

// hoofdclasse
public class Adresboek extends JFrame {

    // opstartclasse
    public static void main(String[] args) {
        // maak een frame
        JFrame frame = new Adresboek();
        frame.setSize(335, 395);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Adresboek");
        frame.setContentPane(new Gast1(frame));
        // frame.setContentPane(new Beheer1());
        frame.setVisible(true);
        frame.setResizable(false);
    }

    // het paneel
    static class Gast1 extends JPanel {

        // de knoppen, textvelden en labels
        private JTextField TF1_VNaam, TF1_TussenVoegsel, TF1_ANaam, TF1_Straat, TF1_SNummer, TF1_Postcode,
                TF1_Plaatsnaam, TF1_GD, TF1_Tel, TF1_Email, TF1_Zoeken;
        private JLabel L1_VNaam, L1_TussenVoegsel, L1_ANaam, L1_Straat, L1_Postcode, L1_Plaatsnaam, L1_GD, L1_Tel,
                L1_Email;
        private JButton B1_Instellingen, B1_Zoeken, B1_Vorige, B1_Volgende;

        public Gast1(final JFrame maker) {
            super();

            // layout manager uit
            setLayout(null);

            // Textvelden
            TF1_VNaam = new JTextField(10);
            TF1_TussenVoegsel = new JTextField(10);
            TF1_ANaam = new JTextField(10);
            TF1_Straat = new JTextField(10);
            TF1_SNummer = new JTextField(10);
            TF1_Postcode = new JTextField(10);
            TF1_Plaatsnaam = new JTextField(10);
            TF1_GD = new JTextField(10);
            TF1_Tel = new JTextField(10);
            TF1_Email = new JTextField(10);
            TF1_Zoeken = new JTextField(10);

            // Labels
            L1_VNaam = new JLabel("Voornaam:");
            L1_TussenVoegsel = new JLabel("Tussenvoegsel:");
            L1_ANaam = new JLabel("Achternaam:");
            L1_Straat = new JLabel("Straat + Nr:");
            L1_Postcode = new JLabel("Postcode:");
            L1_Plaatsnaam = new JLabel("Plaatsnaam:");
            L1_GD = new JLabel("Geboortedatum:");
            L1_Tel = new JLabel("Telefoon:");
            L1_Email = new JLabel("E-mail:");

            // Knoppen
            ImageIcon login2 = new ImageIcon(getClass().getResource("instellingen.png"));
            B1_Instellingen = new JButton(login2);
            ImageIcon search = new ImageIcon(getClass().getResource("search.png"));
            B1_Zoeken = new JButton(search);
            B1_Vorige = new JButton("<<");
            B1_Volgende = new JButton(">>");

            // plaatsing
            // textvelden
            TF1_VNaam.setBounds(110, 50, 210, 25);
            TF1_TussenVoegsel.setBounds(110, 80, 210, 25);
            TF1_ANaam.setBounds(110, 110, 210, 25);
            TF1_Straat.setBounds(110, 140, 160, 25);
            TF1_SNummer.setBounds(275, 140, 45, 25);
            TF1_Postcode.setBounds(110, 170, 210, 25);
            TF1_Plaatsnaam.setBounds(110, 200, 210, 25);
            TF1_GD.setBounds(110, 230, 210, 25);
            TF1_Tel.setBounds(110, 260, 210, 25);
            TF1_Email.setBounds(110, 290, 210, 25);
            TF1_Zoeken.setBounds(10, 330, 140, 26);

            // labels
            L1_VNaam.setBounds(10, 50, 90, 25);
            L1_TussenVoegsel.setBounds(10, 80, 90, 25);
            L1_ANaam.setBounds(10, 110, 90, 25);
            L1_Straat.setBounds(10, 140, 90, 25);
            L1_Postcode.setBounds(10, 170, 90, 25);
            L1_Plaatsnaam.setBounds(10, 200, 90, 25);
            L1_GD.setBounds(10, 230, 95, 25);
            L1_Tel.setBounds(10, 260, 90, 25);
            L1_Email.setBounds(10, 290, 90, 25);

            // knoppen
            B1_Instellingen.setBounds(265, 10, 50, 25);
            B1_Zoeken.setBounds(155, 330, 50, 25);
            B1_Vorige.setBounds(210, 330, 50, 25);
            B1_Volgende.setBounds(265, 330, 50, 25);

            // Font
            Font Font1 = new Font(B1_Instellingen.getFont().getName(), B1_Instellingen.getFont().getStyle(), 11);
            Font Font2 = new Font(B1_Zoeken.getFont().getName(), B1_Zoeken.getFont().getStyle(), 11);
            Font Font3 = new Font(B1_Vorige.getFont().getName(), B1_Vorige.getFont().getStyle(), 11);
            Font Font4 = new Font(B1_Volgende.getFont().getName(), B1_Volgende.getFont().getStyle(), 11);

            // instellen Font
            B1_Instellingen.setFont(Font1);
            B1_Zoeken.setFont(Font2);
            B1_Vorige.setFont(Font3);
            B1_Volgende.setFont(Font4);

            // het toevoegen van de velden, labels en knoppen
            // toevoegen velden
            add(TF1_VNaam);
            add(TF1_TussenVoegsel);
            add(TF1_ANaam);
            add(TF1_Straat);
            add(TF1_SNummer);
            add(TF1_Postcode);
            add(TF1_Plaatsnaam);
            add(TF1_GD);
            add(TF1_Tel);
            add(TF1_Email);
            add(TF1_Zoeken);

            // toevoegen labels
            add(L1_VNaam);
            add(L1_TussenVoegsel);
            add(L1_ANaam);
            add(L1_Straat);
            add(L1_Postcode);
            add(L1_Plaatsnaam);
            add(L1_GD);
            add(L1_Tel);
            add(L1_Email);

            // toevoegen knoppen
            add(B1_Instellingen);
            add(B1_Zoeken);
            add(B1_Vorige);
            add(B1_Volgende);

//Anonymous inner classes FTW
            B1_Zoeken.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e) {
                    System.out.println("Hello Bestand!");
                    JFrame frame1 = new Adresboek();
                    frame1.setSize(335, 395);
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame1.setTitle("Adresboek1");
                    frame1.setContentPane(new Beheer1(frame1));
                    frame1.setVisible(true);
                    frame1.setResizable(false);
                    maker.dispose();
                }
            });


        }// sluit de constructor af

    }

    // Class Beheer
    static class Beheer1 extends Gast1 {

        // de knoppen, textvelden en labels
        private JButton B1_Wijzigen, B1_Aanmaken, B1_Verwijderen, B1_Opslaan, B1_Instellingen;

        public Beheer1(JFrame maker) {
            super(maker);

            // Images Knoppen
            ImageIcon edit = new ImageIcon(getClass().getResource("aanpas.png"));
            ImageIcon add = new ImageIcon(getClass().getResource("nieuw.png"));
            ImageIcon delete = new ImageIcon(getClass().getResource("verwijderen.png"));
            ImageIcon save = new ImageIcon(getClass().getResource("opslaan.png"));
            ImageIcon login = new ImageIcon(getClass().getResource("instellingen.png"));


            // Knoppen Aanmaken
            B1_Wijzigen = new JButton(edit);
            B1_Aanmaken = new JButton(add);
            B1_Verwijderen = new JButton(delete);
            B1_Opslaan = new JButton(save);
            B1_Instellingen = new JButton(login);

            // Plaatsing
            this.B1_Wijzigen.setBounds(10, 10, 50, 25);
            this.B1_Aanmaken.setBounds(62, 10, 50, 25);
            this.B1_Verwijderen.setBounds(114, 10, 50, 25);
            this.B1_Opslaan.setBounds(166, 10, 50, 25);
            this.B1_Instellingen.setBounds(265, 10, 50, 25);

            // Knoppen Toevoegen
            add(B1_Wijzigen);
            add(B1_Aanmaken);
            add(B1_Verwijderen);
            add(B1_Opslaan);
            add(B1_Instellingen);
        }
    }
}
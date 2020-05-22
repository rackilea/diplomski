package test.accueil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AccueilPanel extends Fenetre{

    public AccueilPanel(Dimension dim){
        super();
        initPanel();
    }

    public void initPanel(){
        JLabel titre = new JLabel("Bienvenue dans le jeu du pendu\n");
        titre.setHorizontalAlignment(JLabel.CENTER);
        b4.add(titre, BorderLayout.NORTH);

        b4.add(new JLabel(new ImageIcon("images/moon.jpg")), BorderLayout.CENTER);

        JTextArea texte = new JTextArea("Bienvenue dans mon jeu ! ");

        texte.setEditable(false);
        texte.setBackground(Color.white);

        b4.add(texte, BorderLayout.SOUTH);
    }

}
package test.accueil;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;


public class Fenetre extends JFrame{    


  public Fenetre(){

      JPanel pan = new JPanel();
        //Définition de sa couleur de fond
        pan.setBackground(Color.YELLOW);        
        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(pan);               
        this.setVisible(true);  
    this.setTitle("Box Layout");
    this.setSize(900,900);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);



    JPanel b1 = new JPanel();
    //On définit le layout en lui indiquant qu'il travaillera en ligne
    b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
    b1.add(new JButton("Jouer !"));
    b1.setBackground(Color.YELLOW); 


    JPanel b2 = new JPanel();
    b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
    b2.add(new JButton("Instructions"));
    b2.add(new JButton("Scores"));
    b2.setBackground(Color.YELLOW); 



    JPanel b4 = new JPanel();
    //On positionne maintenant ces trois lignes en colonne
    b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
    b4.add(b1);
    b4.add(b2);
    b4.setBackground(Color.YELLOW);


    this.getContentPane().add(b4);
    this.setVisible(true);    


  }

  protected JPanel getPanel(){
        return this.b4;
    }   
    protected JPanel b4;    


    public static void main(String[] args) {    
    Fenetre fenetre = new Fenetre();
    }
}
public class MenyTest extends JFrame implements ActionListener{

JPanel panel;
JMenuBar menyrad;
JMenu fargmeny,svmeny;
JMenuItem rod,gron,bla,svart,gra,vit;

public MenyTest() {
     panel = new JPanel();
       panel.setBackground(Color.white);
       add(panel);

       menyrad = new JMenuBar();
       fargmeny = new JMenu("Färger");
       svmeny = new JMenu("SvartVitt");
       this.setJMenuBar(menyrad);
       menyrad.add(fargmeny);
       menyrad.add(svmeny);

       rod = new JMenuItem("Röd");
       gron = new JMenuItem("Grön");
       bla = new JMenuItem("Blå");
       svart = new JMenuItem("Svart");
       gra = new JMenuItem("Grå");
       vit = new JMenuItem("Vit");

       fargmeny.add(rod);
       fargmeny.add(gron);
       fargmeny.add(bla);

       svmeny.add(svart);
       svmeny.add(gra);
       svmeny.add(vit);
       rod.addActionListener(this);
       gron.addActionListener(this);
       bla.addActionListener(this);
       svart.addActionListener(this);
       gra.addActionListener(this);
       vit.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
     if (e.getSource() == rod) panel.setBackground(Color.red);
       else if (e.getSource() == gron) panel.setBackground(Color.green);
       else if (e.getSource() == bla) panel.setBackground(Color.blue);
       else if (e.getSource() == svart) panel.setBackground(Color.black);
       else if (e.getSource() == gra) panel.setBackground(Color.gray);
       else if (e.getSource() == vit) panel.setBackground(Color.white);  

}
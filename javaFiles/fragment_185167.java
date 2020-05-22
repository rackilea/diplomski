import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Ex3 extends JFrame {

    private JList lista;
    private JList listaCopia;
    private static final String[] cores = {"Azul", "Verde", "Amarelo"};
    private static final Color[] cor = {Color.blue, Color.green, Color.yellow};
    private JButton copiar;
    DefaultListModel model;

    public Ex3() {
        super("Utilizando JList");
        copiar = new JButton(" Copiar >>>> ");

        lista = new JList(cores);
        setLayout(new FlowLayout());
        lista.setVisibleRowCount(3); // definida linhas visíveis
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // método de seleção única de opções
        add(lista);
        add(copiar);
        copiar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       listaCopia.setListData(lista.getSelectedValuesList().toArray());
                    }
                });
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                getContentPane().setBackground(cor[lista.getSelectedIndex()]);

            }
        });
        listaCopia = new JList<String>();
        listaCopia.setVisibleRowCount(3);
        listaCopia.setFixedCellWidth(100);
        listaCopia.setFixedCellHeight(15);
        add(new JScrollPane(listaCopia));
    }

    private static void createAndShowGui() {
        Ex3 frame = new Ex3();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
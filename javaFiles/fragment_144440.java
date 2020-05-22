import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.*;


public class MainApp extends JFrame implements ActionListener, MouseListener
{

    private String ans;
    private int ans2;
    private boolean over;

    private int li=-1;
    private int li2=-1;
    private int li3=-1;

    private JFrame frame;

    private JButton button1;
    private JButton button2;
    private JButton button3;

    private JButton gfbutton;
    private JButton rbutton;

    private JLabel label;
    private JLabel label2;
    private JLabel label3;

    private JTextArea area;
    private JTextArea area2;
    private JTextArea area3;

    private JList list;
    private JList list2;
    private JList list3;

    private DefaultListModel ListModel;
    private DefaultListModel ListModel2;
    private DefaultListModel ListModel3;

    public static Catalogs cat = new Catalogs();
    public static String Items;
    public static String RentsList;



    public void lists(JTextArea area, JLabel label, JList list) //For games and films
    {
        boolean flag=false;
        int i=0;

        while(i<cat.items.size() && flag==false)
        {
            if( cat.items.get(i).getProname().equals ( list.getSelectedValue() ) )
            {
                area.setText(cat.items.get(i).toString());

                String pathimage = "Images/" + cat.items.get(i).getProname() + ".jpg";

                label.setIcon(new ImageIcon(pathimage));

                flag=true;
            }

            i++;
        }

        if(cat.items.get(i).getRentnum()>0)
            cat.rentItems.add(cat.items.get(i).RentItem());     
         else   
            JOptionPane.showMessageDialog(null,"Sorry...","There are no available copies left",JOptionPane.INFORMATION_MESSAGE); 
    }




    public void mouseClicked(MouseEvent event)
    {                       

        if (list.getSelectedIndex() != li) 
        {
            lists(area, label, list);
        }

        else if (list2.getSelectedIndex() != li2) 
        {
            lists(area2, label2, list2);
        }

        else if (list3.getSelectedIndex() != li3) 
        {
            boolean flag=false;
            int i=0;

            while(i<cat.rentItems.size() && flag==false) 
            {
                if( cat.rentItems.get(i).getProname().equals ( list.getSelectedValue() ) )
                {
                    area.setText(cat.rentItems.get(i).toString());

                    String pathimage = "Images/" + cat.rentItems.get(i).getProname() + ".jpg";

                    label.setIcon(new ImageIcon(pathimage));

                    flag=true;
                }

                i++;
            }
        }

        li = list.getSelectedIndex();
        li2 = list2.getSelectedIndex();
        li3 = list3.getSelectedIndex();
    }

    public void mouseExited(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}
    public void mouseReleased(MouseEvent event){}
    public void mousePressed(MouseEvent event){}


    public void actionPerformed(ActionEvent e) 
    {
        if  (e.getSource() == button1) {
            cat.items.get(list.getSelectedIndex()).RentItem();
        }

        else if  (e.getSource() == button2) {
            cat.items.get(list2.getSelectedIndex()).RentItem();
        }

        else if (e.getSource() == button3) 
        {
            boolean flag=false;
            int i = list3.getSelectedIndex();

            if (i != -1) 
            {

                while(i<cat.items.size() && flag==false) //Find the product in items via renting name
                {
                    if( cat.items.get(i).getProname().equals( cat.rentItems.get(i).getProname() ) )
                    {
                        cat.items.get(i).setRentnum( cat.items.get(i).getRentnum() + 1 );
                        flag=true;
                    }

                    i++;
                }

                ListModel3.remove(i);
                cat.rentItems.remove(i);
            }
        }

    }



    public void RentShop(String type, Catalogs cat, DefaultListModel ListModel) //Function for renting each product
    {
        for(Products product : cat.items)
        {   
                if ( product.getType().equals(type) ) 
                    ListModel.addElement( product.getProname() );           
        }
    }


    private void run() {
        //First window for importing

        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Importing...");

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton gfbutton = new JButton("Select File for Games and Films");
        JButton rbutton = new JButton("Select File for Rents");

        gfbutton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                JFileChooser fi = new JFileChooser();
                int returnValue = fi.showOpenDialog(null);

                if (returnValue == fi.APPROVE_OPTION) {
                   Items = fi.getSelectedFile().getPath();
                }

                if(over==true) frame.dispose();
                over = true;
            }

        });

        rbutton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent ae) 
            {
                JFileChooser fi = new JFileChooser();
                int returnValue = fi.showOpenDialog(null);

                if (returnValue == fi.APPROVE_OPTION) {
                    RentsList = fi.getSelectedFile().getPath();
////////////////////??????????
                }

                if(over==true) 
                {
                    frame.dispose();
                    MainPro();
                }
                over = true;
            }
        });
    }


    //--------------------------------------------------Main program

    public static void main(String args[]) 
    {   
        new MainApp().run();
    }


    /**
      * I have no idea what you're doing here but this should also not be static
      */
    private void MainPro(){

        frame = new JFrame("Video Club"); //?

        frame.setBounds(500,300,400,500);
        frame.add(gfbutton);
        frame.add(rbutton);
        frame.pack();
        frame.setVisible(true);


        L_File lf = new L_File(cat,"Items.txt", "RentsList.txt"); //Importing
        lf.loadFile();


        //Main window, 1st tab

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();

        tabbedPane.addTab("Movies",null,panel1,"Movies");

        JList list = new JList();


        list.addMouseListener(this);
        panel1.add(list);

        JTextArea area = new JTextArea("Details");
        panel1.add(area,BorderLayout.SOUTH);
        ListModel = new DefaultListModel();


        setBounds(300, 300, 350, 150);


        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());


        panel1.setLayout(new FlowLayout());

        button1= new JButton("Rent");
        button1.addActionListener(this);

        panel1.add(button1);

        area.setFont(new Font("Serif", Font.ITALIC, 18));
        area.setForeground(Color.BLUE);
        area.setEditable(false);

        cp.add(panel1, BorderLayout.LINE_START);


        // A JList presents the user with a group of items (DefaultListModel)

        list = new JList(ListModel);
        list.setSelectedIndex(0);

        // A JScrollPane provides a scrollable view of a component

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(150, 100));
        cp.add(listScroller, BorderLayout.CENTER);


        label = new JLabel();
        //label.setIcon(new ImageIcon(products.get(0).getImagePath()));
        cp.add(label, BorderLayout.LINE_END);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RentShop("Film",cat,ListModel);



        //2nd tab

        JPanel panel2 = new JPanel();

        tabbedPane.addTab("Games",null,panel2,"Games");

        JList list2 = new JList();


        list2.addMouseListener(this);
        panel2.add(list2,BorderLayout.SOUTH);

        JTextArea area2 = new JTextArea("Details");
        panel2.add(area2);
        DefaultListModel ListModel2 = new DefaultListModel();


        setBounds(300, 300, 350, 150);


        Container cp2 = getContentPane();
        cp2.setLayout(new BorderLayout());


        panel2.setLayout(new FlowLayout());

        button2= new JButton("Rent");

        panel2.add(button2);
        button2.addActionListener(this);


        area2.setFont(new Font("Serif", Font.ITALIC, 18));
        area2.setForeground(Color.BLUE);
        area2.setEditable(false);


        cp2.add(panel2, BorderLayout.LINE_START);


        // A JList presents the user with a group of items (DefaultListModel)

        list2 = new JList(ListModel);
        list2.setSelectedIndex(0);

        // A JScrollPane provides a scrollable view of a component

        JScrollPane listScroller2 = new JScrollPane(list);
        listScroller2.setPreferredSize(new Dimension(150, 100));
        cp2.add(listScroller2, BorderLayout.CENTER);


        label2 = new JLabel();
        //label2.setIcon(new ImageIcon(products.get(0).getImagePath()));
        cp2.add(label2, BorderLayout.LINE_END);


        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RentShop("Game",cat,ListModel2);


    //3rd tab

        JPanel panel3 = new JPanel();

        tabbedPane.addTab("Rents",null,panel3,"Rents");

        JList list3 = new JList();


        list3.addMouseListener(this);
        panel3.add(list3,BorderLayout.SOUTH);

        JTextArea area3 = new JTextArea("Details");
        panel3.add(area3);
        DefaultListModel ListModel3 = new DefaultListModel();

        setBounds(300, 300, 350, 150);

        Container cp3 = getContentPane();
        cp3.setLayout(new BorderLayout());


        panel3.setLayout(new FlowLayout());

        button3= new JButton("Remove Rent");


        panel3.add(button3);
        button3.addActionListener(this);

        area3.setFont(new Font("Serif", Font.ITALIC, 18));
        area3.setForeground(Color.BLUE);
        area3.setEditable(false);


        cp3.add(panel3, BorderLayout.LINE_START);


        // A JList presents the user with a group of items (DefaultListModel)

        list3 = new JList(ListModel2);
        list3.setSelectedIndex(0);

        // A JScrollPane provides a scrollable view of a component

        JScrollPane listScroller3 = new JScrollPane(list);
        listScroller3.setPreferredSize(new Dimension(150, 100));
        cp3.add(listScroller3, BorderLayout.CENTER);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //After designing:

        for(Rents rent : cat.rentItems)
        {    
            ListModel3.addElement( rent.getProname() );         
        }


        JOptionPane.showMessageDialog(null,"Total Cost","The total renting cost is " + cat.CalculateTotalCost() + " drachmes",JOptionPane.PLAIN_MESSAGE); 

        add(tabbedPane);


    }

}
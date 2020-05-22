package com.demo.combo.icon;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class ShowConboWithIcons extends JFrame {

private static final long serialVersionUID = 1L;

private static final ImageIcon INFO_ICON  = new ImageIcon("info.png");
private static final ImageIcon NONE_ICON  = new ImageIcon("none.png");
public final String NONE_STR = "None";
private final String INFO_STR = "Info";

private JComboBox comboBox;
private JPanel    topPanel;

private String[] str_arr = null; 


public ShowConboWithIcons(String[] str_arr) {
    this.str_arr = str_arr;     
}


public void createGUI(){

    setMinimumSize(new Dimension(100,100));
    setTitle("Demo");
    setLocation(200, 200);

    topPanel = new JPanel();
    getContentPane().add(topPanel, BorderLayout.CENTER);

    Map<Object, Icon> icons = new HashMap<Object, Icon>(); 

    icons.put(NONE_STR, NONE_ICON); 
    icons.put(INFO_STR, INFO_ICON); 

    comboBox = new JComboBox();
    comboBox.setRenderer(new IconListRenderer(icons));
    comboBox.addItem("None");

    for(String val : str_arr){
        comboBox.addItem(val);
    }

    topPanel.add(comboBox);

    super.addWindowListener(new WindowAdapter() {           
        public void windowClosing(WindowEvent e) {              
            dispose();          
        }           
    }); 
}

public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

    UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );   

    String[] str_arr = {"A", "B", "C", "D", "E"};

    ShowConboWithIcons T = new ShowConboWithIcons(str_arr);
    T.createGUI();
    T.setVisible(true);        
}


class IconListRenderer extends DefaultListCellRenderer{ 
    private static final long serialVersionUID = 1L;
    private Map<Object, Icon> icons = null; 

    public IconListRenderer(Map<Object, Icon> icons){ 
        this.icons = icons; 
    } 

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,boolean isSelected, boolean cellHasFocus)
    { 
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 

        // Get icon to use for the list item value 
        Icon icon = icons.get(value); 

        if(!value.toString().equals(NONE_STR)){
            icon = icons.get(INFO_STR);
        }

        // Set icon to display for value 
        label.setIcon(icon); 
        return label; 
    } 
}
}
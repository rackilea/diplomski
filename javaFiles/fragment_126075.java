public static JScrollPane GraphPanel() 
{             // some code here
    ImageIcon imgIcon=new ImageIcon(FILE_NAME.filename+".png");
    label.setIcon( imgIcon);
    pane2.add(label);
    JScrollPane grphPane= new JScrollPane(pane2);
    return grphPane;
}
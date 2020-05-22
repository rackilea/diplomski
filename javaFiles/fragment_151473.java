public class ReadFileToListM  {

public ReadFileToListM() throws IOException{
    JFrame frame=new JFrame();
    ReadFileToList rftl=new ReadFileToList();
    JTable table=new JTable(rftl);
    JPanel panel=new JPanel();
    JScrollPane sp=new JScrollPane(table);
    panel.add(sp);
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(470,470);
    frame.setVisible(true);
}

public static void main(String[] args) throws IOException{
    new ReadFileToListM();
}
}
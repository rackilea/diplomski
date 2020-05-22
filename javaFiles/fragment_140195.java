public class PhoneOrganiser extends JFrame {
    public static void main(String[] args){


    //creation of the Window
    JFrame frame = new JFrame ("Phone Organiser");
    frame.setSize(200, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    //declaring the type of Table, Number of columns and rows
    final String col[] ={"Number", "Type", "IP", "Protocol", "Line"};
    final DefaultTableModel tableModel = new DefaultTableModel (col,30);

    //create the table
    final JTable table = new JTable(tableModel);

    //add the Table to the scrollpane
    JScrollPane scrollpane = new JScrollPane(table);
    frame.add(scrollpane);

    //creating the Menu bar
    JMenuBar menubar = new JMenuBar();
    frame.setJMenuBar(menubar);

    //adding menus
    JMenu file = new JMenu ("File");
    menubar.add(file);

    JMenu help = new JMenu ("Help");
    menubar.add(help);

    //adding items inside the menus
    JMenuItem open = new JMenuItem ("Open");
    file.add(open);

    JMenuItem save = new JMenuItem ("Save");
    file.add(save);


    JMenuItem exit = new JMenuItem ("Exit");
    file.add(exit);


    //When the program starts for the first time, it creates a new txt file
    Path path = Paths.get("/Users/PhoneData.txt");
    try{
        Files.createFile(path);
        System.out.println("file created");
    }catch (IOException e1){
        System.out.println("file already exists");
    }

    //saving data from TABLE -> TO TXT - It can be done with FileChooser in V2

    class SaveData extends JFrame implements ActionListener {

        public void actionPerformed (ActionEvent e){

            try{

                File file = new File ("C:\\Inne\\PhoneData.txt"); //declaring the path of the file
                FileWriter fw = new FileWriter (file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter (fw);

                //rows
                for (int i =0; i < table.getRowCount(); i++){

                    for (int j=0; j < table.getColumnCount(); j++){
                        String value = (String)table.getModel().getValueAt(i, j);
                        if((value == null || "null".equals(value))) {
                            value = "";
                        }
                        bw.write(value+";"); //write the contents to the file
                    }
                    bw.write("/");
                    bw.newLine();
                }
                bw.close();
                fw.close();

            }catch (IOException e2){

            }//end catch

        }//end action method


    }
    save.addActionListener(new SaveData()); //end SaveData class

    //reading data from TXT -> TO TABLE

    class OpenData extends JFrame implements ActionListener{

        public void actionPerformed (ActionEvent e){

            String line = null;
            try{

                File file = new File ("C:\\Inne\\PhoneData.txt");
                FileReader fr = new FileReader (file.getAbsoluteFile());
                BufferedReader br = new BufferedReader (fr);

                StringBuilder builder = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }
                String[] lineArray= builder.toString().split("/");
                table.setModel(new DefaultTableModel(col,0));
                for(String currentLine: lineArray){
                    String[] dataArray = currentLine.split(";");
                    ((DefaultTableModel)table.getModel()).addRow(dataArray);
                }
                br.close();

            }catch (IOException e3){


            }//end catch

        }//end action method

    }open.addActionListener(new OpenData());//end OpenData class

}
}
public class DosCommandsWindow extends JFrame{

/**
 * 
 */
JLabel progressMsg, firstMsg, enFolderMsg, dbMsg, shortcutMsg, finishedMsg;
ImageIcon img;
int flag;
JProgressBar pbar;

public DosCommandsWindow(){
    super("DNA ENDOCRINO");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.img = new ImageIcon("logo.png");
    this.setIconImage(this.img.getImage());

    this.flag=1;

    this.firstMsg=new JLabel("Please wait...");
    this.progressMsg=new JLabel("Progress");
    this.enFolderMsg=new JLabel("Create C:\\Endocrino folder...");
    this.dbMsg=new JLabel();
    this.shortcutMsg=new JLabel();
    this.finishedMsg=new JLabel();

    pbar = new JProgressBar();
    pbar.setMinimum(0);
    pbar.setMaximum(4);
    this.pbar.setValue(1);

    this.setSize(300, 200);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
}//constractor

public void createForm(int rows,int columns,int vgap,int hgap)//orizei sto panel tou frame topothethsh sumfwna me to GridLayout
{
    JPanel panel=new JPanel();
    GridLayout g=new GridLayout(rows,columns,vgap,hgap);
    panel.setLayout(g);
    this.setContentPane(panel);

    this.add(this.progressMsg);
    this.add(this.pbar);
    this.add(this.firstMsg);
    this.add(this.enFolderMsg);
    this.add(this.dbMsg);
    this.add(this.shortcutMsg);
    this.add(this.finishedMsg);

    SwingUtilities.invokeLater(new Runnable() {
          public void run() {

            if(flag==1){
                DosCommands.createEnFolder();
                createDB();
            }

            else if(flag==2){
                DosCommands.createDB();
                createShortcut();
            }
            else{
                DosCommands.createShortcut();
                JOptionPane.showMessageDialog(null,"Now you can delete the Endocrino folder from your Desktop");
                System.exit(0);
            }
        }
    });
}//createForm

public void createDB(){
    this.dbMsg.setText("Create Data Base...");
    this.pbar.setValue(2);
    createForm(7,1,3,3);
    this.flag++;
}

public void createShortcut(){
    this.shortcutMsg.setText("Create shortcut...");
    this.pbar.setValue(3);
    createForm(7,1,3,3);
    this.flag++;
    this.finishedMsg.setText("Finished");
    this.pbar.setValue(4);
}
}//DosCommandsWindow
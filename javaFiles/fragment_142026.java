String m_uname = ManagerID.getText();
String m_pw = managerpw.getText();

try
{
    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\L\\Desktop\\NewAssignmentOODJ\\textfile\\ManagerLoginDetails.txt"));
    String reader;
    boolean login = false;

    while ((reader = br.readLine())!=null)
    {
        String[] split = reader.split(" ");
        if (m_uname.equals(split[0]) && m_pw.equals(split[1]))
        {
            login = true;
            ManagerForm mform = new ManagerForm();
            mform.setVisible(true);
            this.setVisible(false);
            break;
        }
    }
    if(!login)
    {
        JOptionPane.showMessageDialog(null,"Whoops!","Error",JOptionPane.ERROR_MESSAGE);
    }
 }

catch (Exception e)
{
    JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
}
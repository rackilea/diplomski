public class textview extends JFrame implements ActionListener
{  
Scanner scan;  
static String name;
JButton fetch;
JTextField text1;
testview2 t2 = new testview2();

public static void main(String args[])
{
new textview();
}
public textview()
{
setLayout(new FlowLayout());
setSize(200, 200);
fetch = new JButton("FetchData");
text1 = new JTextField(20);
add(fetch);
fetch.addActionListener(this);
add(text1);
setVisible(true);
t2.Open();
}
@Override
public void actionPerformed(ActionEvent e) 
{
if(e.getSource()==fetch)
    {  
       text1.setText(t2.Read());  
    } 
}
}

class testview2 {
Scanner scan;
static String name;
boolean flag=false;
public void Open()  
{  
    try  
    {  
        scan =new Scanner(new File("C:/temp.txt")); 
        flag=true;
    }  
    catch(FileNotFoundException e)  
    {  
        flag=false;
        System.out.println("It wont working");  
    }
}  
public String Read()  
{   
    if(flag)
        name=scan.next();
    else
        return "End of the file";

    System.out.println(name); 
    if(!scan.hasNext())
    {
        scan.close();
        flag=false;
    }
    return name;
}
}
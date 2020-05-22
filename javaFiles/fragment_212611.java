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
@Override
public void actionPerformed(ActionEvent e) 
{
    if(e.getSource()==fetch)
    {  
        text1.setText(Read());  
    }
}
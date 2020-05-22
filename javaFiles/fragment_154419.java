interface Bank
{
   public void withdraw();
   public void deposit();
   //Other methods    

}
class ABC_Bank implements Bank
{
 //Implementation of methods defined by Bank Interface ,
   User Username;                    //can also include its Own methods
}

class User
{
 String name;
 //Other fields and getter setter methods

}
class PrivilegedUSer extends User
{
    //Methods specific to privileged User. 
}
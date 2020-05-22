public class EmailValid {
 public static void main (String[] args) {
 System.out.print("Please Enter Your Email To Validate: ");
 Scanner input = new Scanner (System.in);
 String email  = input.nextLine();
 boolean flag=false;
 int countr=0,countd=0;
 loop:for (int i=0; i < email.length();i++) {                 //Better to iterate loop till end of the String "email"
 if(email.charAt(i)=='@'){
  countr++;
  if(countr>1){
   flag=false;
   break loop;
  }
   if(i>=1) 
   flag=true;
   else{
   flag=false;
   break loop;
    }
  }
 if(email.charAt(i)=='.'){
  countd++;
  if(countd>1){
      flag=false;
      break loop;}
   if(i>=3)
 flag=true;
 else{
   flag=false;
   break loop;}
if(email.length()>=i+3)
  flag=true;
 else{
  flag=false;
  break loop;}
 }
 if((email.indexOf(".")-email.indexOf("@"))>=2)
{
  flag=true;}
 else {
  flag=false;
  break loop;}
if(((int)email.charAt(i))>=65 && ((int)email.charAt(i))<=90)
 flag=true;
 else if(((int)email.charAt(i))>=97 && ((int)email.charAt(i))<=122)
 flag=true;
 else if(((int)email.charAt(i))>=48 && ((int)email.charAt(i))<=57)
 flag=true;
 else if(((int)email.charAt(i))==64 || ((int)email.charAt(i))==46)
 flag=true;
 else
 flag=false;
 //@ must at least have a char before itself and also there must be a character between '@' and '.'--So mininmum index of '@' >=1 and for '.' >=3.
 if(flag==false)
break loop;
 }
 if(flag==true && email.length()>=5)    // The minimum length of the String must be equal to minimum index of '.' +2, i.e., >=5. 
  System.out.println("Validated");
  else 
  System.out.println("Invalid Email");
   }
  }
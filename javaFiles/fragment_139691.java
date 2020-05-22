for(int i = 0; i < commonPass.length; i++) 
{
  if (password.contains(commonPass[i])) 
  {
     System.out.println("Enter new password.");
     password = kb.nextLine();
  }
}
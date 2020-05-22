private void convertButtonActionPerformed(java.awt.event.ActionEvent evt)        
{                                              
Scanner user_input = null;
Scanner scanner = null;
try
{
user_input = new Scanner(tempTextField.getText());

String seq1 = user_input.next();


scanner = new Scanner(new File(seq1));
scanner.nextLine();
String content = scanner.useDelimiter("\\Z").next();


int N = content.length();

textarea.append("Length of the input string is: "+N);
}catch(FileNotFoundException e)
{
 e.printStackTrace();
}finally
{
 //always close scanner
 if(user_input != null)
    user_input.close();

  if(scanner  != null)
    scanner.close();



}
}
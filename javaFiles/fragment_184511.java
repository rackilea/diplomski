try
 {
 FileInputStream in = new FileInputStream("records.txt");
 BufferedReader br = new BufferedReader(new InputStreamReader(in));
 String strLine;
 StringBuffer sb = new StringBuffer();
 while((strLine = br.readLine())!= null)
 {
     sb.append(strLine +"\n");
 }
 JOptionPane.showMessageDialog( null, sb.toString());
 }catch(Exception e){
 JOptionPane.showOptionDialog(null, "Error", "Customers",       JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
 }
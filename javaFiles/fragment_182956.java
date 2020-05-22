try
{
 FileWriter fw = new FileWriter(new File("file_location"+".txt"));   
 fw.write(
 "Name : "            +"\n"+
 "Telephone Number : "+"\n"+
 "Email-Address : "   +"\n"+
 "Address : "         +"\n"+
 "Gender : "          +"\n"+
 "Occupation : "      +"\n"+
 "Salary : "          +"\n"+
 "Is Manager : "      +"\n"+
 );
 fw.close();
}
catch(Exception ex){ex.printStackTrace();}
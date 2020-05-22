public void CompareFileMain()
{
   /*int tempvar = 0;
   int tempvar1 =0 ;*/
   String Tlines1[] = new String [100];
   String Tlines2[] = new String [100];
   String tempstring1 = null;
   String tempstring2 = null;
   int file1lines;
   int file2lines ;
   System.out.println(file1lines = linesOffile1());
   System.out.println(file2lines = linesOffile2());
   try {
    file1 = new BufferedReader(new FileReader(SOAPFile));
    file2 = new BufferedReader(new FileReader(RestFile));
    int oplines = 1;
    while ((sCurrentLine1 =file1.readLine()) != null ) 
    {
        tempstring1 = sCurrentLine1;
        while ((sCurrentLine2 =file2.readLine()) != null )
        {
               tempstring2 = sCurrentLine2;
                }
        if ((sCurrentLine2 =file2.readLine()) == null)
        {
           System.out.println("File 1 --> line# "+oplines +"\t");
           CompareFileSub(tempstring1, tempstring2);
        }
        oplines = oplines+1;
    }
        } catch (IOException e) {
        e.printStackTrace();
        }
}
public void CompareFileSub(String t1, String t2) throws IOException  // reading file 2 
{
  file2 = new BufferedReader(new FileReader(RestFile));
  int oplines = 1;
  while ((sCurrentLine2 =file2.readLine()) != null )
  {
    t2 = sCurrentLine2;
    if((t1.contains(t2) && (t2.contains(t1))))
    {
          System.out.print(t1+"-->"+t2+"---->matched \t");
          System.out.println("File 2 --> line# "+oplines +"\n");
    }
    else
    {
          System.out.print(t1+"-->"+t2+"---->not matched \t");
          System.out.println("File 2 --> line# "+oplines +"\n");
    }
              oplines = oplines+1;
 }
}

public int linesOffile1() //Count file 1 lines
{
  try {
    while ((sCurrentLine1 =file1.readLine()) != null )
    {
        //System.out.println("Taken line sCurrentLine1 "+sCurrentLine1);
        //System.out.println("Taken line sCurrentLine1 "+i);
        i=i+1;
    }                                   
        } catch (IOException e) {
            e.printStackTrace();
            }
   finally {
    try {
           if (file1 == null)file1.close();
         } catch (IOException ex) {
                ex.printStackTrace();
                }
    }
   return i;

}      
public int linesOffile2() //Count file 2 lines
{
  try {
    while ((sCurrentLine2 =file2.readLine()) != null )
    {   
    //System.out.println("Taken line sCurrentLine2 "+sCurrentLine2);
    //System.out.println("Taken line sCurrentLine2 "+j);
    j=j+1;
    }
        } catch (IOException e) {
            e.printStackTrace();
            }   
  finally {
    try {
        if (file2 == null)file1.close();
    } catch (IOException ex) {
            ex.printStackTrace();
            }
    }
 return j;
}
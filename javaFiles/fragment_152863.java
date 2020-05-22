NxParser nxp = new NxParser(new FileInputStream("filetoparse.nq"),false);

while (nxp.hasNext()) 
{
  Node[] ns = nxp.next();
  if (ns.length == 3)
  {
    //Only Process Triples  
    //Replace the print statements with whatever you want
    for (Node n: ns) 
    {
      System.out.print(n.toN3());
      System.out.print(" ");
    }
    System.out.println(".");
  }
}
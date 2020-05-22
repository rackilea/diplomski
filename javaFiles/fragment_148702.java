do {
    searchkey = JOptionPane.showInputDialog("Please tell us which painting you thihnk is the best? \n Vote A for Mona Lisa \n Vote B for Water Lilies \n                                    Vote C for The Scream \n Vote D for A Young Rembrandt");
    for (int i=0; i<art.length; i++)
    {
        if (art[i].equals(searchkey))
        {   vote[i]=vote[i]+1; 
        }   
     }
} while (!searchkey.equals("hello"));
JOptionPane.showMessageDialog(null,"The current votes are:\n" +vote[0]+ " : " +painting[0]+"\n"+vote[1]+" : " +painting[1]+                             "\n" +vote[2]+" : "+painting[2]+ "\n" +vote[3]+" : " +painting[3]);
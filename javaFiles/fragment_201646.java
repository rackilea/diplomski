for(int i=0; i< devicesDiscovered.size(); i++) 
{
    System.out.println("test if this gets output");
    String test = (String) devicesDiscovered.elementAt(i).toString();
    System.out.println("Test: " + test);
}
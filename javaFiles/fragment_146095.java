try
      {
     FileOutputStream fileOut = new FileOutputStream("card.ser");//creates a card serial file in output stream
     ObjectOutputStream out = new ObjectOutputStream(fileOut);//routs an object into the output stream.
     out.writeObject(array);// we designate our array of cards to be routed
     out.close();// closes the data paths
     fileOut.close();// closes the data paths
  }catch(IOException i)//exception stuff
  {
      i.printStackTrace();
}
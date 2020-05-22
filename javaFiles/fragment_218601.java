Product p = new Product("My Product");
    try
    {
       FileOutputStream fileOut =
       new FileOutputStream("product.ser");
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
       out.writeObject(p);
       out.close();
       fileOut.close();
    } catch(IOException ioe)
    {
        ioe.printStackTrace();
    }
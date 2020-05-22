Product p = null;
    try
    {
        FileInputStream fileIn = new FileInputStream("product.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        p = (Product) in.readObject();
        in.close();
        fileIn.close();
    } catch(IOException ioe)
    {
        ioe.printStackTrace();
        return;
    } catch(ClassNotFoundException c)
    {
        System.out.println(.Product class not found.);
        c.printStackTrace();
        return;
    }
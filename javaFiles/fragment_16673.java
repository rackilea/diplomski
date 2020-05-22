try
        {
          fis = new FileInputStream("treeObject.dat");
          ois = new ObjectInputStream(fis);
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
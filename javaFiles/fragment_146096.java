try// If this doesnt work throw an exception
         {
            FileInputStream fileIn = new FileInputStream(name+".ser");// Read serial file.
            ObjectInputStream in = new ObjectInputStream(fileIn);// input the read file.
            object = (Object) in.readObject();// allocate it to the object file already instanciated.
            in.close();//closes the input stream.
            fileIn.close();//closes the file data stream.
        }catch(IOException i)//exception stuff
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)//more exception stuff
        {
            System.out.println("Error");
            c.printStackTrace();
            return;
        }
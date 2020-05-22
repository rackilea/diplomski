try {
        ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("garage.txt"))));
        for(;;){
            try {
               str += ((Vehicule)ois.readObject()).toString();
            } catch (EOFException eofe) {
               break;
            }
        }
        ois.close();
      }
} catch ....
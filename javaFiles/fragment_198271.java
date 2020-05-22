try {
        FileOutputStream fos = new FileOutputStream("Filename.ser");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.write(obj);
        fos.close();
        out.close();

    } catch (IOException ex) {}
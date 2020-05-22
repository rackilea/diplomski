try {
        FileOutputStream fs = new FileOutputStream("college.foo");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(college);
        os.writeInt(1); //adding the id !
        os.writeInt(75019); //adding the zip !
        os.writeObject("name"); //adding the name !
        os.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
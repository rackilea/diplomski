class MyClass implements Serializable {

    private static final long serialVersionUID = 1L;

    int a1;
    float b1;
    char c1;     //This is a single character
}


private File file;
private MyClass myClass;

private void writeIt() throws IOException {

    ObjectOutputStream stream = null;
    try {
        stream = new ObjectOutputStream(new FileOutputStream(file));
        stream.writeObject(myClass);
    } 
    finally {
        if(stream != null) {
            stream.close();
        }
    }
}

private MyClass readIt() throws IOException, ClassNotFoundException {

    ObjectInputStream stream = null;
    try {
        stream = new ObjectInputStream(new FileInputStream(file));
        return (MyClass) stream.readObject();
    } 
    finally {
        if(stream != null) {
            stream.close();
        }
    }
}
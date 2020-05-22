public String toString() {
    String str = "**********************  Display    **************************** \n";
    ObjectInputStream ois = null;

    try {
        ois = new ObjectInputStream(new FileInputStream("Person.txt"));

        while (true) {
            try {
                str += (((Person) ois.readObject()).toString());
            } catch (EOFException ex1) {
                break;
            }
        }
    } catch (EOFException ex1) {
        System.err.println("File is empty\n");
    } catch (ClassNotFoundException e) {

    } catch (IOException e) {

    }finally {
        if (ois != null) {
            try {
                ois.close();
            }catch (IOException e) {
                System.err.println("Error closing ois");
                e.printStackTrace();
            }
        }
    }

    return str;
}
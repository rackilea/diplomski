public void addPerson(Person p1) throws EOFException {
    Lpersonne.add(p1);

    ObjectOutputStream oos = null;

    try {
        FileOutputStream out = new FileOutputStream("Person.txt");
        oos = new ObjectOutputStream(out);

        for (Person P : Lpersonne) {
            oos.writeObject(P);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }finally {
        if (oos != null) {
            try {
                oos.close();
            }catch (IOException e) {
                System.err.println("Error closing out oos");
                e.printStackTrace();
            }
        }
    }
}
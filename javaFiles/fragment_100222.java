//load contacts
public void incarcareContacte() throws IOException, ClassNotFoundException {

    try (
            InputStream file = new FileInputStream("contacts.txt");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);) {
        //deserialize the List
        List<Abonat> recoveredContacts = (ArrayList<Abonat>) input.readObject();
        //display its data
        for (Abonat contacts : recoveredContacts) {
            System.out.println("Recovered contacts: " + contacts);
        }
        listaContacte = recoveredContacts;

    } catch (ClassNotFoundException ex) {
        fLogger.log(Level.SEVERE, "Cannot perform input. Class not found.", ex);
    } catch (IOException ex) {
        fLogger.log(Level.SEVERE, "Cannot perform input.", ex);
    }
}
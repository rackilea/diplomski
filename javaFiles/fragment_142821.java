class Phonebook {
    //Make the constructor private so no one can create objects, but this class
    private Phonebook() {
    }
    // to static members to hold (m_Instance) and get (getInstacnce) the Singleton Instance of the class
    private static Phonebook m_Instance;
    public static Phonebook getInstance() {
        if (m_Instance == null) {
            // first call to getInstance, creates the Singelton Instance, only we (Phonebook) can call the constructor;
            m_Instance = new Phonebook(); 
        }
        return m_Instance; //always the same Instance of Phonebook
    }
    ... // Members of the Phonebook (add/getPhoneNumber)
}
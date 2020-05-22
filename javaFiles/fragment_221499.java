class Patron {
    void kickOut() {
        // ServiceLocator finds a class which implements the Barable interface.
        Barable service = ServiceLocator.ByInterface("Barable"); 
        service.bar(); <<-- Invoke it. We don't care HOW it works, or WHO implemented it!
    }
}
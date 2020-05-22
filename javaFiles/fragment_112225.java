public abstract class Contact {

    private final String name;

    public Contact(String name) {
        this.name = name;
    }

    public String displayContact() {
         return "Contact name: " 
                + name + ". Contact type: " 
                + this.getClass().getName() + ". ";
    }
}
// concrete commands will implement this interface
// you can also use an abstract class if you want to have certain attributes, such as a TicketSystem
public interface Command { 
    // this method can be set to return something useful instead of void, if needed
    void execute();
}
// We can combine the functionality of North and South 
// in a single class
public class NorthSouth {
    public void CreateQueue() { ... }
    public void poll() { ... }

    // etc.
}

public class Main {
    public static void main(String[] args) {
        NorthSouth north = new NorthSouth();
        NorthSouth south = new NorthSouth();

        north.CreateQueue();
        south.CreateQueue();

        // etc.
    }
}
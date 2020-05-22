public class Call extends CallNode {
    public int id;

    // Simplification of method
    public CallNode hasMissingCall() {  
        if (true)
            return this;
        // ...
    }
    public int getId()
    {
         return this.id;
    }
}
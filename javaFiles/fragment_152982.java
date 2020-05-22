public class A { 
    public void save() { 
         // Perform save logic
    }
}

public class B extends A {
    private Object b;
    @Override
    public void save() { 
        super.save(); // Performs the save logic for A
        save(b); // Perform additional save logic
    }
}
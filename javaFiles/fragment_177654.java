public class Main {    
    public <T> SomeInterface<T> getImplementation(Class<T> clazz) {
        if(SpecificClass.class.isAssignableFrom(clazz))
        {
            // do some specific stuff

            // unchecked cast here...
            return (SomeInterface<T>) getSpecificImplementation((Class<SpecificClass>) clazz); 
        }
        else
        {
            // do other stuff
            return new CatchAllImplementation<T>();
        }
    }

    private <T extends SpecificClass> SomeInterface<T> getSpecificImplementation(Class<T> clazz) {
        return new SpecificImplementation<T>();
    }

    public static void main(String[] args) {
        Main m = new Main();
        SomeInterface<SpecificClass> implementation = m.getImplementation(SpecificClass.class);

        System.out.println("Result: " + implementation.getClass());
        SomeInterface<Object> catchAll = m.getImplementation(Object.class);

        System.out.println("Result: " + catchAll.getClass());

        SomeInterface<SpecificClassChild> implementationForChild = m.getImplementation(SpecificClassChild.class);

        System.out.println("Result: " + implementationForChild.getClass());
    }
}
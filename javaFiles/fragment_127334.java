public class Module extends AbstractModule{

    public Module(){
        super(() -> System.out.println("message"));         
    }

    @Override
    protected void doStuff() {
        // do stuff     
    }   

}
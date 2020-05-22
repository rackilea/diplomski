public class ConcreteFactory extends AbstractFactory{
    // USE THIS IF YOU NEED TO SHARE THE VECTOR AMONGST MULTIPLE FACTORY INSTANCES
    public ConcreteFactory(Vector vector){
        super(vector);
    }
    // OR USE THIS IF THE VECTOR IS SPECIFIC TO THE FACTORY
    public ConcreteFactory(){
        super(new Vector());
    }    

    public Circle createCircle(){
        Circle circle = new Circle();
        getVector().add(circle);
        return circle;
    }
}
abstract class Animal{
    public abstract void run(){}
}

@Component
@Scope("prototype")
class Dog extends Animal{}


@Component
@Scope("prototype")
Class Cat extends Animal{}
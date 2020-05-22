class A<T extends Animal> {
    protected T anim;
    public A(){
    }
}

class B extends A<Dog> {
    public B(){
       anim = new Dog();
    }

    private doSomething(){
       anim.accessDogMethod();
    }
}
abstract class Category {
    public void doSomething() {
        Foo f = makeFoo();
        f.whatever();   
    }

    abstract void toHtml();
}

class Category1 extends Category {
    public override void toHtml() {
        ... // do something here
    }
} 

class Category2 extends Category {
    public override void toHtml() {
        ... // do something else here
    }
}
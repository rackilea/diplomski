class Foo {

    String title;

    void setTitle(String title) { this.title = title; }

    Foo clone(Foo foo){
        Foo result=new Foo();
        result.setTitle(foo.title);
        return result;
    }
}
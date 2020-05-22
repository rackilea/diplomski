abstract class Messager{

    private  Messager nextMessager;

    void setNextMessager(Messager messager){
        this.nextMessager = messager;
    }

    Messager getNextMessager(){
        return this.nextMessager;
    }

    abstract void handle(Pojo pojo);
}

class FooMessager extends Messager{

    void handle(Pojo pojo){
       //operate on your pojo
       if(pojo.getHref == null){
           pojo.setHref("broken");
       }

       if(this.getNextMessager() != null){
           this.getNextMessager().handle(pojo);
       }

    }
}

class BarMessager{

     void handle(Pojo pojo){
       //operate on your pojo
       if(pojo.getHref().contains("broken")){
          pojo.setHref(pojo.getHref().replace("broken","fixed"));
       }

       if(this.getNextMessager() != null){
           this.getNextMessager().handle(pojo);
       }

    }

}

class Pojo{

    private String href;

    public Pojo() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}

class Test{

     public static void main(String[] args) {

         Pojo pojo = new Pojo();
         pojo.setHref(null);

         Messager foo = new FooMessager();
         Messager bar = new BarMessager();
         foo.setNextMessager(bar);

         foo.handle();
     }
}
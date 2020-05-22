class MyObject<T extends Model>{

    Class<T> targetClass;

    public MyObject(Class<T> targetClass){
       this.targetClass = targetClass; 
    }

    public void doSomething(T model){
          //do some stuff
    }
}
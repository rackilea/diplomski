public interface DoSomething {
    void doSomething1();
    void doSomething2();
    void doSomething3();
}

public class VisitorProcessing {

    public void dispatch( DoSomething ds) {
        if(condition1....)
            ds.doSomething1();
       else{
           if(condition2){
               ds.doSomething2();
           }
           else{
               ds.doSomething3();
           }
       } 
    }

    public void visit(EventA eventA){
        DoSomething ds = new DoSomething()
        {
            void doSomething1() {
             // Do somethings 1
            }
            void doSomething2(){
             // Do something 2
            }
            void doSomething3(){
             // Do something 3
            }
        }
        dispatch( ds );
    }

    public void visit(EventB eventB){
        DoSomething ds = new DoSomething()
        {
            void doSomething1() {
             // Do somethings 3
            }
            void doSomething2(){
             // Do something 4
            }
            void doSomething3(){
             // Do something 5
            }
        }
        dispatch( ds );
    }
    ...
}
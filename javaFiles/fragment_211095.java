public interface TransferableData {
    void invokeMethod();
}


public class A implements TransferableData {

   @Override
   public void invokeMethod() {
        //Your business logic A
   }
}

public class B implements TransferableData {

    @Override
    public void invokeMethod() {
        //Your business logic for B
    }
}
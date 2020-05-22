class Box { 

    public static class PrivateObject {
       private value;

       private increment(){
         value++;
       }
    }

    private PrivateObject prv;

    public void setPrivateObject(PrivateObject p){
        prv = p;
    }

    public void changeValue(){
        prv.increment();
    }       
}
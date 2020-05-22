public class StackExample {

  // Other declaration here ----------

  public static void main(String[] args){

    MethodCollection collection = new MethodCollection();

    String[] methods = {"method1", "method2", "method3"};

    // requires to catch exception just in case the method does not exist
    try {
        for (String a : methods) {
            glPushMatrix(); // <----- Push matrix
            MethodCollection.class.getMethod(a, null).invoke(collection,null);
            glPopMatrix();  // <----- Pop matrix
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }

  }

 static class MethodCollection {

    /**
     * Empty constructor
     */
    public MethodCollection(){}

    public void method1(){
        System.out.println("Method 1");
    }

    public void method2(){
        System.out.println("Method 2");
    }

    public void method3(){
        System.out.println("Method 3");
    }
  }
}
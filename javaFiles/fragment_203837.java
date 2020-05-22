public class MyImplementation implements MyInterface {
       // perhaps you need a reference to the ZK Component here
       private Component comp;
       public MyImplementation(Component comp){
         this.comp = comp;
       }
    }

    public class CustomBandBox  extends Bandbox implements MyInterface {
        private MyImplementation impl = new MyImplementation(this);

        public Integer getSolution(){
          return impl.getSolution();
        }
    }
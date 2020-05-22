public class MyList {
       private int value;
       private MyList next;

       public MyList(int value, int length) {
           this.value = value;
           if (length > 1) {
              next = new MyList(value, length - 1);
           }
       }
   }
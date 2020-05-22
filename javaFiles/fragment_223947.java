public class My_program {

My_program() { }


public void connect_to_db(String connect_string) {
      Class.forName(...);
      ......
   }

public static void main(String[] args) {
   String connect_string = "jdbc......";
   My_program db = new My_program();
   db.connect_to_db(connect_string)
}
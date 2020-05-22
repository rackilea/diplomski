class MyClass {

 public static void main(String[] args) throws InterruptedException {
   do {
        Thread.sleep(5000);
        writeToSQL();
   } while(true);
 }
 static void writeToSQL() {
   System.out.println("writing to SQL");
 }

}
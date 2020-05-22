void run() {
     Scanner reader = new Scanner(System.in);
     System.out.println("Enter a number: ");
     String string = reader.nextString();
     MyObject obj = new MyObject();
     obj.doSomething(string);
     obj.render();
 }
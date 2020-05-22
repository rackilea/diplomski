private static Mensola mensolaInstance;
[...]
public static Mensola getInstance() { 
     if (mensolaInstance == null)
         mensolaInstance = new Mensola(20); // or whatever
     return mensolaInstance;
}
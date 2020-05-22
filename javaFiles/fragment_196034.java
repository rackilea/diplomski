public class Factory {
   public static Consumer getConsumer( Object o ){
    Consumer e = new Eat();
    Consumer w = new Water();
    if( e.canProcess( o ) )
       return e;
    else if ( w.canProcess( o ) )
       return w;
   }
}
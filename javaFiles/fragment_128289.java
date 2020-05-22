jaxbUnmarshaller.setListener(new Listener()
{
     private int position = 0;
     @Override
     public void beforeUnmarshal(Object target, Object parent) 
     {
         if ( target instanceof Aaa )
         {
             position++;
             Aaa aaa = (Aaa)target;
             aaa.setPosition( position );
         }
         else if ( target instanceof Bbb )
         {
             position++;
             Bbb bbb = (Bbb)target;
             bbb.setPosition( position );
         }

     }
});
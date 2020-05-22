public abstract class AndroidGame extends Activity implements Game {

   public void newActivity(Intent intent)  {
      startActivity( intent ); 
   }

   public void newActivity(Class<?> cls)  {
      startActivity( new Intent( this, cls ) );
   }
}
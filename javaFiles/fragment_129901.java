public class Item{
   private CharSequence title;
   private Class activityClass;
   public Item(String s){

       String args[] = s.split(',');
       if(args.lengt==2){
         title = args[0];
         activityClass = new Class(args[1]);
       }

   }
public Item(int titleResId, Class activityClass) {
    this.title = getResources().getString(titleResId);
    this.activityClass = activityClass;
}

   @Override
   public String toString(){
     return title.toString() + "," + activityClass.toString();
  }
}
public class ClassB {
   Context context;
   public ClassB(Context context){
     this.context=context;
   }

   public void Update(){
        TextView txtView = (TextView) ((Activity)context).findViewById(R.id.text);
        txtView.setText("Hello");
   }
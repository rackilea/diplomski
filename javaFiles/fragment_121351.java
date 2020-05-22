Class Aa extends Activity {

   public initAndRunBeAcitvity(int parameterInt){
      ContainerWithData data = new ContainerWithData();
      data.setIntegerValue(parameterInt);
      runBe(data);
   }

   public void runBe(ContainerWithData data){
      Intent intent = new Intent(Aa.this,Be.class);
      intent.putExtra("MyBeData",data);
      startActivity(intent); 
   }

}

Class Be extends Activity {

   protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      prepareInitParameters();
   }

   private void prepareInitParameters(){
     getInitParameters();
     checkInitParameters();
   }

   private void getInitParameters(){
     ContainerWithData value = getIntent().getSerializableExtra("MyBeData");
     this.value = value;
   }


   private void checkInitParameters(){
      if (value==null){
               //Perform any initialization data, 
               //message or postDelayed closing of activity
       } 
   }


}

Class ContainerWithData implements Serializable {

   @Getter
   @Setter
   private Integer integerValue; 
   //can be null if not setted, 
   //so should be checked by if conditions later on controller of view logic

}
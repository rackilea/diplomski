public abstract class BaseActivityClass extends Activity {
    int layout_id = R.layout.SomeLayout;
    final int menu_button_id = R.id.menuButton;
    final int save_button_id = R.id.saveButton;

    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(layout_id);

       Button btn = findViewById(menu_button_id);
       btn.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            //this functionality will be same on every child class
        }
       });

       // Get the ViewStub, set the derived class's content layout on it and inflate it,
       // thereby displaying the derived class's view layout within the base class's 
       // "content area"
       ViewStub vs = findViewById(viewStub);
       vs.setLayout(getContentLayoutId());
       vs.inflate();
   }

   // Define abstract method that all derived classes must implement to provide
   // the id of the layout to show in the "content area"
   @LayoutRes
   public abstract int getContentLayoutId();
}
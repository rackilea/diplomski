public class Help_DialogScreen extends Dialog implements OnClickListener{
 Context context;
    public Help_DialogScreen(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        this.context=context;
    }

    @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.help_homescreen);

        EditText tvGoToAddExpense = (EditText)findViewById(R.id.txtGoToAddExpense);

        Button btnTestCLick = (Button)findViewById(R.id.btnTestClick);

        btnTestCLick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "Click fired", Toast.LENGTH_SHORT).show();
                // I have used Toast to show that on click of button, dialog is not getting dismissed. You can add your code and do your logic here.
            }
        });


      }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        dismiss();
    }

}
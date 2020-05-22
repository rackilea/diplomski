private EditText et1, et2;
private Button bt1;

@Override
protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mt11);

    et1 = findViewById(R.id.mt1011);
   // et2 = (EditText) findViewById(R.id.mt1012);

    bt1 = (Button) findViewById(R.id.mt1sgpa1);

    bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        showGrade(calculateGrage(et1.getText().toString()));
        }
    });
}

private String calculateGrage(String range) {
    int S = 10, A = 9, B = 8, C = 7, D = 6, E = 4, F =0;
    int num = 0, result = 0;
    try {
        num = Integer.parseInt(range);
    } catch (NumberFormatException nfe) {
        //Not in correct format
    }
   if(num == 0 || num < 0) {
     result = F;
   } else {
       if (num <= 41) {
           result = F;
       } else if (num <= 44) {
           result = E;
       } else if (num <= 59) {
           result = D;
       } else if (num <= 69) {
           result = C;
       } else if (num <= 79) {
           result = B;
       } else if (num <= 89) {
           result = A;
       } else {
           result = S;
       }
   }
    return String.valueOf(result);
}

private void showGrade(String grade) {
    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
    alertDialog.setTitle("New Semester");
    alertDialog.setMessage("Your Grade is : " + grade);
    //Showing Alert Message
    alertDialog.show();
}
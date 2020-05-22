@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_expense);

    ExpenseName = (EditText) findViewById(R.id.txt_expensename);
    ExpenseCost = (EditText) findViewById(R.id.txt_expensecost);

    final Button btn_addexpense = findViewById(R.id.btn_addexpense);
    btn_addexpense.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                //Validating the log in data
                boolean validationError = false;

               StringBuilder validationErrorMessage = new StringBuilder("Please, insert ");
                if (isEmpty(ExpenseCost)) {
                    validationError = true;
                    validationErrorMessage.append("the cost of the expense");
                }
                if (isEmpty(ExpenseName)) {
                    if (validationError) {
                        validationErrorMessage.append(" and ");
                    }
                    validationError = true;
                    validationErrorMessage.append("the name of the expense");
                }
        }
    }); // here
}

private boolean isEmpty(EditText text) {
    if (text.getText().toString().trim().length() > 0) {
        return false;
    } else {
        return true;
    }
}
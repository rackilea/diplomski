@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.add_person: {
            createAddPersonDialog().show();
        }
        default: {
            return super.onOptionsItemSelected(item);
        }
    }
}

private Dialog createAddPersonDialog() {
    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

    // Inflate using dialog themed context.
    final Context context = builder.getContext();
    final LayoutInflater inflater = LayoutInflater.from(context);
    final View view = inflater.inflate(R.layout.add_form, null, false);

    // Find widgets inside "view".
    final EditText name = (EditText) view.findViewById(R.id.person_name);
    final RadioGroup mradioGroup = (RadioGroup) view.findViewById(R.id.gender_selection);
    final RadioButton male = (RadioButton) view.findViewById(R.id.male);
    final RadioButton female = (RadioButton) view.findViewById(R.id.female);
    final EditText weight = (EditText) view.findViewById(R.id.person_weight);
    final EditText height = (EditText) view.findViewById(R.id.person_height);
    final EditText age = (EditText) view.findViewById(R.id.person_age);

    final View.OnClickListener listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_NEGATIVE) {
                dialog.cancel();
                return;
            }

            String user_name = (String) name.getText().toString();
            String user_gender = (String) gender_value;
            String user_weight = (String) weight.getText().toString();
            String user_height = (String) height.getText().toString();
            String user_age = (String) age.getText().toString();

            boolean isInserted = mydb.insertData(user_name, user_gender, user_weight, user_height, user_age);
            if (isInserted == true)
                Toast.makeText(MainActivity.this, "ADDED", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MainActivity.this, "NOT ADDED", Toast.LENGTH_LONG).show();
        }
     };

     builder
         .setView(view)
         .setCancelable(false)
         .setPositiveButton(android.R.string.ok, listener)
         .setNegativeButton(android.R.string.cancel, listener);
     return builder.create();
}
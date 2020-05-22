builder.show(); // Need to call this first

final EditText input_name = (EditText) edit_distraction_dialog_view.findViewById(R.id.edit_distraction_name_edittext);
final EditText input_priority = (EditText) edit_distraction_dialog_view.findViewById(R.id.edit_distraction_priority_edittext);

//Set positive OK button for alert dialog
builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String new_name = input_name.getText().toString();
                String new_priority = input_priority.getText().toString();
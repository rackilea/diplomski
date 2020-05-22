final EditText input_name = (EditText) edit_distraction_dialog_view.findViewById(R.id.edit_distraction_name_edittext);
final EditText input_priority = (EditText) edit_distraction_dialog_view.findViewById(R.id.edit_distraction_priority_edittext);

// You can debug and set breakpoints on these, though
final String new_name = input_name.getText().toString();
final String new_priority = input_priority.getText().toString();
// An inflater
LayoutInflater inflater = LayoutInflater.from(DistractionsActivity.this);
// An inflated View    
final View edit_distraction_dialog_view = inflater.inflate(R.layout.edit_distractions, null);

// A dialog
final AlertDialog.Builder builder = new AlertDialog.Builder(DistractionsActivity.this);
builder
    .setTitle("Edit Distraction")
    .setView(edit_distraction_dialog_view); // You already called setView!

// Don't need to call it again!
// builder.setView(R.layout.edit_distractions);
@Override
public void onClick(View v) {
    Intent myIntent = new Intent(v.getContext(), Main3Activity.class);
    myIntent.putExtra("TITLE_EXTRA", title.getText().toString())
    v.getContext().startActivity(myIntent);
}
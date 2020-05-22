button.setOnClickListenr(new View.OnClickListener() {
@Override
public void onClick(View view) {
    String str = myTextView.getText().toString();
    presenter.doSomething(str);
)}
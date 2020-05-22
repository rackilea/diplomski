LayoutInflater inflater = getLayoutInflater();
View dialoglayout = inflater.inflate(R.layout.showwinner, null);
AlertDialog dialog;
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setView(dialoglayout);
dialog = builder.create();
Button btnOk = (Button) dialoglayout.findViewById(R.id.btnOk);
TextView tv = (TextView) dialoglayout.findViewById(R.id.txtText2);
tv.settext(moveCounter.getText());
btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
dialog.getWindow().getAttributes().windowAnimations =R.style.dialog_animation;
dialog.show();
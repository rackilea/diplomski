final Dialog dialog = new Dialog(MainActivity.this);
    dialog.setContentView(R.layout.dialog_news_description);//Your custom layout
    TextView sometextview = dialog.findViewById(R.id.textView);// Textview in your custom layout
    Button somebutton = dialog.findViewById(R.id.button_done);// Button in your layout
    somebutton.setOnClickListener(new View.OnClickListener() {//on button click listener
        @Override
        public void onClick(View view) {
            //DO your job.... 
            //then...
            dialog.dismiss();//dismiss the dialog
        }
    });
    dialog.show();
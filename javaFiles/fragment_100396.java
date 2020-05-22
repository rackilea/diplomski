AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
    // ...Irrelevant code for customizing the buttons and title
    LayoutInflater inflater = this.getLayoutInflater();
    View dialogView = inflater.inflate(R.layout.alert_label_editor, null);
    dialogBuilder.setView(dialogView);


    Button button = (Button)dialogBuilder.findViewById(R.id.btnName);

    button.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

         //Commond here......

       }
   });

    button.setOnLongClickListener(new OnLongClickListener() {

        @Override
        public boolean onLongClick(View v) {
            // TODO Auto-generated method stub
            return false;
        }
    });

    AlertDialog alertDialog = dialogBuilder.create();
    alertDialog.show();
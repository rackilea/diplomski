private Button getSwtitchact;
    {
      final Button switchact = (Button) findViewById(R.id.button3);
      switchact.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          selectedValue=mySpinner.getSelectedItem().toString(); // here you get the selected items from spinner
          if(selectedValue.equals("a"))
          {
          Intent act = new Intent(view.getContext(), xy.class);
          startActivity(act);
          }
          else if(selectedValue.equals("B"))
          {
          Intent act = new Intent(view.getContext(), xyZ.class);
          startActivity(act);
          }
          else
         {
           ......
         }
        }
      });
    }
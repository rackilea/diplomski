btn01.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
             Button btn = (Button) v;
             disp.append(btn.getText());
         }
     });
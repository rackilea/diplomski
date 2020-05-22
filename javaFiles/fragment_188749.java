final Dialog dialog = new Dialog(context);
dialog.setContentView(R.layout.pop); // pop is my dialog xml
dialog.setTitle("Phone Call");
TextView text = (TextView) dialog.findViewById(R.id.text1);
text.setText(values[0]); 
text.setOnClickListener(new View.OnClickListener()
  {
        public void onClick(View view) 
         {
          Intent dial = new Intent();
          dial.setAction("android.intent.action.DIAL");
          dial.setData(Uri.parse("tel:"+Global.values[0]));
          startActivity(dial);

         }
    });
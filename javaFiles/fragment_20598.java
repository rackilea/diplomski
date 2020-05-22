encryptBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      String plntxt= plainText.getText().toString();
      String noOflines= noOfLines.getText().toString();
      int lines = 0;
      try {
        lines = Integer.parseInt(noOflines);
      }
       catch (NumberFormatException e){

      }

      encryption(plntxt, finalLines);
    }
});
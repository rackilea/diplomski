final Button yourButton= findViewById(R.id.yourButtonID);
    final String Array[] = {"Dog goes woof", "Cat goes meow", "Cow goes moo", "Etc..."};
    final TextView yourTextView = findViewById(R.id.yourTextViewID);
    yourButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = 0;
            if(textView.getText() == null)
            {
                textView.setText(Array[1]); // initial value
            }
            else{
                for(int i=0;i<Array.length;i++){
                  if(Objects.equals(textView.getText(),Array[i])){
                    position=i; //got the selected position
                    break;
                  }
                }
                if(position<Array.length-1){
                    textView.setText(Array[position+1]); 

                }
                else{
                    textView.setText(Array[position-1]);
                }
            }
        }
    });
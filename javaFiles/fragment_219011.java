@Override
        public void onClick(View v) {

            //use encrypted value
            String str = TextToMirror.getText().toString;
            for(int i=0; i<str.length();i++){
               char ch = str.charAt(i);
               char temp  = cryptxt(ch) 
               TextOut.setText(temp);
            } 

        }
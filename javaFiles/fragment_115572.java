OnClickListener listener1 = new OnClickListener(){

        public void onClick(View v) {
            try{
              value = Double.parseDouble(text.getText().toString());
            } catch (final NumberFormatException e) {
              value = 1.0;
            }

            mark = convertUp(value);  

            tv1.setText(""+mark);  
        }        
    };

    OnClickListener listener2 = new OnClickListener(){

        public void onClick(View v) {
            try{
              value = Double.parseDouble(text.getText().toString());
            } catch (final NumberFormatException e) {
              value = 1.0;
            }

            mark = convertDown(value);   

            tv1.setText(""+mark); 
        }     
    };
holder.btnIncrease.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
               int val = 0; 
                try{

                val = Integer.parseInt(holder.number.getText().toString());  
                }catch(Exception e) {
                val = 0; 
                }
                holder.number.setText (String.valueOf (val++));

            }
        });
        holder.btnDecrease.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {


                int val = 0; 
                try{

                val = Integer.parseInt(holder.number.getText().toString());  
                }catch(Exception e) {
                val = 0; 
                }
                if(val>0) val--;
                holder.number.setText (String.valueOf (val));

            }
        });
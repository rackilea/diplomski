//Gets the value from the text field which is assigned to the variable val.vn and also passed to the local variable vn;
double vn = val.vn = Double.parseDouble(jTextField9.getText());
//Using if clauses to evaluate vn within one of the 3 tables
      if(vn <= 69){//table 1
          //A tdd is assigned to the variable val.tdd according to the interval it belongs to
          if(val.iscil > 0) {
              if (val.iscil<=20){
                  val.tdd = 5.0;              
              }else if(val.iscil <= 50){
                  val.tdd = 8.0;
              }else if(val.iscil <= 100){
                  val.tdd = 12.0;
              }else if(val.iscil <= 1000){
                  val.tdd = 15.0;
              }else
                  val.tdd = 20.0;
           } else{
             //shows an error message that should never be seen but who knows, java always surprises us
             JOptionPane.showMessageDialog(rootPane, "Error al clasificar Isc/IL.", "Extraño Error O.o", JOptionPane.ERROR_MESSAGE);
           }
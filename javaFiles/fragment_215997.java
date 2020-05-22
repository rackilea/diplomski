public String getDisplayValue(char c)
    {   
      if(c == 'h'){
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
         }
      }
      else if(c=='m'){
            return value*60;
      }
    }
but, when there is no appointment, you return true.



public String toString() {

    StringBuilder output = new StringBuilder();
    // String is an immutable object. Consider use StringBuilder

      for(int i = 0; i < isBusy.length; i++)
    {
        if(appointmentDescription[i] != null)
        {
            output.append(appointmentDescription[i]);
            if( i < isBusy.length - 1){
             output.append(", ");
             }
             }

    }
    if (output.isEmpty()) {
      return "No appointments scheduled for this entire day";
    } 
     return output.toString();
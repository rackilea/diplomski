public String fillForm(){
        boolean failTest = false;
        String errorCodeForNcpForm = "";
        StringBuffer buffer = new StringBuffer();        
        buffer.append (" ");        
        if (!unitSerialValue.equalsIgnoreCase("P")){        
            buffer.append (1 +  unitSerialValue  ); 
            failTest = true;
            buffer.append("   ");
        }

        if(!screenProValue.equalsIgnoreCase("P")){        
            buffer.append (2 +  unitSerialValue  );     
            failTest = true; 
            buffer.append("   ");
        }

        if(failTest){
            //gets the whole error code
            errorCodeForNcpForm = buffer.toString(); 

            this.ncpForm.setproblemQcValue(errorCodeForNcpForm);

            return "ncpFormQc";
        } else
            return "index";
    }
package com.pragmaticsoftwaredevelopment.stackoverflow;
...
   final static String formatterZeroes="00000000000000000000000000000000000000000000000000000000000";
   protected static String getFormattedDecimal ( String value, int len, int scale, Boolean signed ) throws IllegalArgumentException {
       if (value.length() == 0) throw new IllegalArgumentException ("Cannot format a zero-length value");
       if (len <= 0) throw new IllegalArgumentException ("Illegal length (" + len + ")");
       StringBuffer retVal = new StringBuffer();
       String sign=null;
       int numStartIdx; 
       if ("+-".indexOf(value.charAt(0)) < 0) {
          numStartIdx=0;
       } else {
          numStartIdx=1;
          if (value.charAt(0) == '-')
             sign = "-";
       }
       if (signed && (value.charAt(0) != '-'))
          sign = "+";
       if (sign==null)
          sign="";
       retVal.append(sign);


       int dotIdx = value.indexOf('.');
       int requestedWholePartLength = (len-scale);

       if (dotIdx < 0) { 
          int wholePartPadLength = (requestedWholePartLength - ((value.length()-numStartIdx)));
          if (wholePartPadLength > 0)
             retVal.append(formatterZeroes.substring(0, wholePartPadLength));
          retVal.append (value.substring(numStartIdx));
          if (scale > 0)
             retVal.append(formatterZeroes.substring(0, scale));
       }
       else {
          int wholePartPadLength = (requestedWholePartLength - (dotIdx - numStartIdx));
          if (wholePartPadLength > 0)
             retVal.append(formatterZeroes.substring(0, wholePartPadLength));
          retVal.append (value.substring(numStartIdx, dotIdx));
          retVal.append (value.substring (dotIdx+1));
          int fractionalPartPadLength = (scale - (value.length() - 1 - dotIdx));
          if (fractionalPartPadLength > 0)
             retVal.append(formatterZeroes.substring(0, fractionalPartPadLength));


       }

       return retVal.toString();
   }
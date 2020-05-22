StringBuilder sb = new StringBuilder();

   /* Declare and initialise variables somewhere in between*/

   sb.append(mbeanAppName);
   sb.append(",");
   sb.append(mbeanAppFQDN);
   sb.append(",");
   sb.append(mbeanAppStatus);

   String generatedStringOutputFromStringBuilder = sb.toString();
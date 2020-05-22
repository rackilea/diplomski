String str = "start";

     String strArray[] = new String [str.length()]; 

     for (int i=0 ; i< str.length() ; i++)
     {
        strArray[i] = str.substring(0,i+1);
        System.out.println("strArray["+i+"] = " +strArray[i]  );
     }
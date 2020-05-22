String str="This is a time to get involve into $FO, $RTP, $DFG and $RG" ;
    String[] arr=str.split(" ");
    for (String i:arr){
         if(i.indexOf("$")==0){
             System.out.println(i.replaceAll("\\,",""));
         }
    }
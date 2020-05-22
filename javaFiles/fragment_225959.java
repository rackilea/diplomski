static void cmp( double result ){
    String strRes1 = String.format("%3.2ef",result);
    DecimalFormat resFormat = new DecimalFormat("0.00E00f");
    String strRes2 = resFormat.format(result);
    if (strRes2.contains("E-"))  strRes2 = strRes2.replace("E", "e");
    else                         strRes2 = strRes2.replace("E", "e+");
    if( ! strRes1.equals( strRes2 ) ){
        System.out.println( strRes1 + " " + strRes2 );
        System.out.println( result );
    }
}
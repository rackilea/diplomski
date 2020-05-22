public static String answer( String M, String F )
{
     BigInteger nM = new BigInteger(M);
     BigInteger nF = new BigInteger(F);
     long count = 0;


     while ( !nM.equals ( nF ) && !nM.equals ( new BigInteger ( "0" ) ) && !nF.equals ( new BigInteger ( "0" ) ) ) 
     {
         BigInteger divide = (nF.max ( nM )).divide ( nF.min ( nM ) );
         count += divide.compareTo ( new BigInteger ( "0" ) ) == 1 ? divide.longValue ( ) : 1;
         BigInteger originalNM = nM;
         BigInteger originalNF = nF;
         nM = originalNM.mod ( originalNF );
         nF = originalNF.mod ( originalNM );
         System.out.println(nM + " " + nF + " " + count); // Print results
     }
     if (nM.intValue ( ) == 0 && nF.intValue ( ) != 1) return "impossible " + (count-1);
     if (nM.intValue ( ) != 1  && nF.intValue ( ) == 0) return "impossible " + (count-1); 

     return "" + (count-1);

}
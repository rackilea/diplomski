private static boolean isValid(String accountLine) throws BankAccountException
{
   StringTokenizer strTok = new StringTokenizer(accountLine, ";");
   boolean valid = true;
   if(strTok.countTokens() == 2)
   {
      String acctNum = strTok.nextToken();
      String acctHolder = strTok.nextToken();
      if(acctNum.length() == 10 
        && acctNum.matches(".*[0-9].*") 
        && !acctHolder.matches(".*[0-9].*"))
      {

        valid = true;

      }
   }
   else
   {
      System.out.println("Invalid Bank Account info. " + strTok.nextToken());
      valid = false;
   }
   return valid;
}
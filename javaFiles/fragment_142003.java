rule "Excellent_Score"
when 
   Context( $creditReportObject : getData("creditReport") )
   CreditReport( creditScore > 800 ) from $creditReportObject 
then
   System.out.println("Excellent");
end
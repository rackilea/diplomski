rule "Excellent_Score_2"
when 
   Context( $creditReport : getData("creditReport"),
            $account: getData("account") )
   ( CreditReport( creditScore > 800 ) from $creditReport
     or
     Account( balance >= 5000 ) from $account )
then
   System.out.println("Excellent");
end
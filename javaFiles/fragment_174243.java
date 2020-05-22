@Inject 
Controller con; 

String bank = con.getUserBank();

if(bank.equals("BofA")) {
  out.println("<input type=\"radio\" name=\"bank\" value=\"BofA" checked>Bank of America");
} else {
  out.println("<input type=\"radio\" name=\"bank\" value=\"BofA">Bank of America");
}
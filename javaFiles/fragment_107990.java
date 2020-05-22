String host = "smtp.gmail.com";
final String user="kishorejohnsan.s@gmail.com"; 
final String password="your gmail account password";//change accordingly  

String to = "kishorejohnsan.s@gmail.com";//change accordingly
//Get the session object
Properties props = new Properties();
props.put("mail.smtp.host", host);
props.put("mail.smtp.auth", true);
props.put("mail.smtp.starttls.enable", true);
props.put("mail.smtp.port", 587);
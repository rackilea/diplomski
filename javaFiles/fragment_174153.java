SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
Date today = Calendar.getInstance().getTime(); 


String A = formatter.format(today);
Date B = formatter.parse(last_sms_date);


if (A.compareTo(B) == -1) { 
System.out.println("A<B"); 
} 
else{
System.out.println("A>B");
}
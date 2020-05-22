SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
Date date=new Date();        
try {
    date = sdf.parse("1 Jan 2013");           
}catch (Exception e) {
    e.printStackTrace();
}
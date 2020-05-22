String dateStr = "04/05/2010"; 

    SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy"); 

    try {
        dateObj = curFormater.parse(dateStr);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
    SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy"); 

    String newDateStr = postFormater.format(dateObj); 
    Toast.makeText(getApplicationContext(), newDateStr, 1).show();
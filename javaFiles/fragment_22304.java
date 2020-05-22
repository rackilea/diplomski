private String dateLongStringConvert(String dateLongString) {

    // split long date string into string array
    String[] dateArray = dateLongString.split(" ");

    // get day of month as an integer (strip out non numeric chars)
    int dayOfMonth = Integer.parseInt(dateArray[0].replaceAll("\\D+", ""));

    // Convert month string to number
    String month = "";
    switch (dateArray[1]) {
        case "January":
            month = "01";
        case "Feburary":
            month = "02";            
        case "March":
            month = "03";            
        case "April":
            month = "04";            
        case "May":
            month = "05";            
        case "June":
            month = "06";            
        case "July":
            month = "07";            
         case "August":
            month = "08";           
          case "September":
            month = "09";          
        case "October":
            month = "10";            
        case "Novemember":
            month = "11";
        case "December":
            month = "12";                
    }
    // return formated date string
    return dateArray[2] + "-" + month + "-" + String.format("%02d", dayOfMonth);
}
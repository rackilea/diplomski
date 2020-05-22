int clientGMT = 4; //GMT you want to convert to
int serverGMT = 2; //server's GMT
int delta = clientGMT - serverGMT; //delta between the dates

//assume this is the date in GMT + 2 received from the server
Date d1 = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").parse("12.03.2019 13:00:00");

//... and you want to convert it to GMT + 4 (client side's time zone)
Date resultDate = new Date(d1.getTime() + delta * 3600000);
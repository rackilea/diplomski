String timerStop1 = String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
String[] timef=timerStop1.split(":");  

int hour=Integer.parseInt(timef[0]);  
int minute=Integer.parseInt(timef[1]);  
int second=Integer.parseInt(timef[2]);  

int temp;  
temp = second + (60 * minute) + (3600 * hour);  

System.out.println("seconds " + temp);
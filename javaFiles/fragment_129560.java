// not really a date, but a Date
Date date1 = new Date(0L);                                   
// really a date, but not a Date
java.sql.Date sqlDate = java.sql.Date.valueOf("1970-01-01"); 
// really a date, but a Date?
Date date2 = sqlDate;                                        
// a Date with time
date1.getHours();                                            
// a Date without time. <-- throws an IllegalArgumentException. 
// Wait, exactly *which* argument is illegal?
date2.getHours();
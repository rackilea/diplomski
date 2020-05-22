s1 = s1.replace("[",""); 
s1 = s1.replace("]","");
String [] band = s1.split(", ");     
s2 = s2.replace("[",""); 
s2 = s2.replace("]","");
String [] hotel = s1.split(", ");    //Comma and a space. Thanks to SaviourSelf
System.out.println( EarliestCommonSlot(hotel,band) );
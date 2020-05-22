char ch1 = ''; //Line feed  
//will be compiled as 
char ch1 = '
';

char ch2 = '\u000d'; //Carriage return
//will be compiled as
'char ch2= ';

char ch3 = '''; // ' character
//will be compiled as 
char ch3=''';

char ch4 = '\u005C'; // \ character
//will be compiled as
char ch4='\';
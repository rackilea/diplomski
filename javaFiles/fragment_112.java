String number = String.valueOf(2.52549856E8f);
int index = number.indexOf('.');
String formatted = 
    number.substring(0, index) + 
    number.substring(index + 1, index + 2) + 
    '.' + 
    number.substring(index + 2);
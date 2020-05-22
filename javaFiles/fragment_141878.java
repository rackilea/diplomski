public static Boolean isLeapYear(int year)
{
    if(year % 4 == 0 && year % 100 != 0)
        return true; 
    return false;   
}
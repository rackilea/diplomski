String result;
int minuteValue = 55;
int hourValue = 9;

if(minuteValue==0){
    result = hourValue + minuteValue + " o'clock"; // eg two o'clock (the String o'clock defined later in the minute values)
}
else if (minuteValue <= 30 ){
    result = minuteValue + " past " + hourValue; // eg ten past five
}
else
{
   int remainingtime = 60 - minuteValue;
   int nexthr = hourValue + 1;
   if(nexthr==13) nexthr = 1;  
   result = remainingtime + " to " + nexthr; // eg twenty to five

}

System.out.println(result);
String str = "12 hi when 8 and 9";
str=str.replaceAll("[\\D]+"," ");
String[] numbers=str.split(" ");
int sum = 0;
for(int i=0;i<numbers.length;i++){
    try{
        sum+=Integer.parseInt(numbers[i]);
    }
    catch( Exception e ) {
      //Just in case, the element in the array is not parse-able into Integer, Ignore it
    }
}
System.out.println("The sum is:"+sum);
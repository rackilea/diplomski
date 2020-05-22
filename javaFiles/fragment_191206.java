String oneLine = "["; 
int lowerAvg = 0;
for (int i = 0; i < howMany; i++) {
if(myArray[i] < avg){
        oneLine += (i > 0 && ++lowerAvg > 0)?", ":""; // add separator
        oneLine += (myArray[i]);
    }
}
oneLine+="]";
System.out.println(oneLine);//prints like [1.0, 2.0, ...]
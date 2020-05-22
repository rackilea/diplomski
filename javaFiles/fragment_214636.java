int NUMBER_OF_TIME = 2;
int n = 1;
boolean bool = true;
int[] timeReadings = {1,2,3,4,5,6,7,8,9,10,11,12};
String array1[] = {"A", "B"};
System.out.print("-----------------"+ System.lineSeparator());
System.out.print(array1[0] + System.lineSeparator());
for(int i : timeReadings) {
    System.out.print(i + " ");
    if(n > (timeReadings.length / NUMBER_OF_TIME) - 1 && bool) {
        System.out.println(System.lineSeparator()+"-----------------");
        System.out.print(array1[1] + System.lineSeparator());
        bool = false;
    }
    n++;
}
System.out.println(System.lineSeparator()+"-----------------");
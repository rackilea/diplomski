for(int i = 0; i<event.length; i++){
    System.out.printf("%4s", event[i]);
    currentWeekDay++;
    if(currentWeekDay==7){
        currentWeekDay=0;
        System.out.println();
    }
}
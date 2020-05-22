int currentWeekDay = 0;
for(int i = 0; i<firstWeekDay; i++){
    System.out.print("    ");
    currentWeekDay++;
    //just in case the firstWeekDay is invalid.
    if(currentWeekDay==7){
        currentWeekDay=0;
        System.out.println();
    }
}
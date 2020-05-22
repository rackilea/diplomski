public int mostPopularDay() { //finds the most popular Day of the year
    int popularDay = 0;
    int max = -1;
    for(int i = 0; i < birthDayStats.length; i++) {
        if(birthDayStats[i] > max) {
            max = birthDayStats[i];
            popularDay = i;            
        }
    }
    return popularDay + 1;  //Adding +1 since there is no 0th day of the month
}
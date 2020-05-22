double max;
double min;

public static void getMaxAndMin(
                   double day1, double day2, double day3, double day4, 
                                double day5, double day6, double day7){

    max = Math.max(day1, day2);
    max = Math.max(max, day3);
    max = Math.max(max, day4);
    max = Math.max(max, day5);
    max = Math.max(max, day6);
    max = Math.max(max, day7);

    min = Math.min(day1, day2);
    min = Math.min(min, day3);
    min = Math.min(min, day4);
    min = Math.min(min, day5);
    min = Math.min(min, day6);
    min = Math.min(min, day7);

}
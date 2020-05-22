public class SingleRoom {
    static final int DAYS  = 7;
    static final int HOURS = 16;
    . . .
    private int[][] timetable = new int[DAYS][HOURS];   //0 would say room is not booked, >0 indicates the booked class (english advanced (12), object oriented programming (139), etc..)
}

public class Solution {
    static final int AVAILABLE_ROOMS = 26;
    . . .
    private SingleRoom[] university_timetable = new SingleRoom[AVAILABLE_ROOMS];    
}
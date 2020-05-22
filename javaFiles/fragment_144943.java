public static Clock parseHHMM(String theTime)
    {
        int hh = Integer.parseInt(theTime.substring(0,1));
        int mm = Integer.parseInt(theTime.substring(3,4));
        return new Clock(hh, mm);

    }
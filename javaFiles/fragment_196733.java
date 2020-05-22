for (int i = minutes - 1; i >= 0; i--){
    String minute;
    if(minutes == 1)
        minute = " minute ";
    else
        minute = " minutes ";

    for (int s = 59; s >= 1; s--){
        String seconds;
        if(s == 1)
            seconds = " second";
        else
            seconds = " second";
        System.out.println(i + minute + s + seconds);
    }
}
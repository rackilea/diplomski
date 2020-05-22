public static void main(String[] args) {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String systemTime = sdf.format(new Date()).toString();

    String START = "09:00:00";
    String END = "09:11:00";

    while (compareTime(systemTime, START, END))
    {
        System.out.println("Your task here");
        systemTime = sdf.format(new Date()).toString();
    }
}

private static boolean compareTime(String systemTime, String START, String END)
{
    return systemTime.compareTo(START) >= 0 && systemTime.compareTo(END) <= 0;
}
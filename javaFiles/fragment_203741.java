public static void main(String[] args) {
    Scanner input2 = new Scanner(System.in);
    System.out.println("Time to be converted to hh:mm:ss: ");
    int time = input2.nextInt();
    int hr = 0, min = 0, sec = 0;
    if (time >= 3600) {
        hr = time / 3600;
        time = time % 3600;
    }
    if (time >= 60) {
        min = time / 60;
        time = time % 60;
    }
    if (time < 60) {
        sec += time;
    }
    System.out.println(hr + ":" + min + ":" + sec);
}
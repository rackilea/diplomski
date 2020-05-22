public static void main (String[] args) throws Exception {
    long input = 9999;
    long hours = (input - input%3600)/3600;
    long minutes = (input%3600 - input%3600%60)/60;
    long seconds = input%3600%60;
    System.out.println("Hours: " + hours + " Minutes: " + minutes + " Seconds: " + seconds);
}
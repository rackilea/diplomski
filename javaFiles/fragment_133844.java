public static void main(String[] args) {
    String deadline = "25/11/2017 11:00:00";
    DateTime utc = new DateTime(DateTimeZone.UTC);
    DateTimeZone timeZone = DateTimeZone.forID("Asia/Dhaka");
    DateTime dhakaTime = utc.toDateTime(timeZone);
    //Dead Line Time
    DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
    DateTime deadlineTime = format.parseDateTime(deadline.trim());

    System.out.println("Deadline : " + deadline);
    System.out.println("Current datetim : " + dhakaTime);
    System.out.println("current datetime + 1 day : " + dhakaTime.plusDays(1));
    System.out.println("current datetime + 2 day : " + dhakaTime.plusDays(2));

    System.out.println("Is deadline after current datetime:" + deadlineTime.isAfter(dhakaTime)); 
    System.out.println("Is deadline after current datetime + 1 day:" + deadlineTime.isAfter(dhakaTime.plusDays(1))); 
    System.out.println("Is deadline after current datetime + 2 day:" + deadlineTime.isAfter(dhakaTime.plusDays(2))); 
}
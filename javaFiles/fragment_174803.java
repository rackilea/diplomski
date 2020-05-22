class Student {
   private String name;
   private String address;
   private String city;
   private String nationality;
   private Data dob;
   private long studentId;
} 

class Performance {
   private long studentId;
   private List<Integer> perfData;
}

class PerformanceManager{
    private List<Performance> performances;

    public List<Performance> getPerformanceForId(long id);
}

class MailItem{
    private String to;
    private String message;
    private long studentId;
}

class MailManager{
    private List<MailItem> mails;
    private List<MailItem> getMailForId(long id);
}
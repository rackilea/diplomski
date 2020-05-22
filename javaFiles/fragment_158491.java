class Remainder {
     private String what;
     private DateTime when;


     public static Remainder remindMe( String what, DateTime when ) {
         Reminder r = new Reminder();
         r.what = what;
         r.when = when;
     }

     public boolean isTimeAlready() {
          //return DateTime.Builder.createTime().compareTo( this.when ) > 0;
          // implemented somehow 
          return isCurrentTimeGreaterThan( this.when ); // assume it return true if current time is after "when"
     }
  }
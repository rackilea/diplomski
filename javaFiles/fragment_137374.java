TimelineItem contactNumber = new TimelineItem()
     {

         Text = "Call Amalan",
         BundleId = "8081",

         Creator = Amalan,
         MenuItems = new List<MenuItem>() {  
                                         new MenuItem() {Action = "VOICE_CALL"},
                                         new MenuItem() {Action = "DELETE"}},
         Notification = new NotificationConfig() { Level = "DEFAULT" },

     };
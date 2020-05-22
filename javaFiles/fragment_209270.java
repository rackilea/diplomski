"notificationSettings": { //name of class: NotificationSettings
    "notifications": [ //array of Notification objects. It means you will need a Notification class as well
                       //and an array or List field called notification in NotificationSettings class
     { //this defines the structure for Notification class
      "type": "eventCreation", //String field called type
      "method": "email" //String field called method
     },
     {
      "type": "eventChange",
      "method": "email"
     },
     {
      "type": "eventCancellation",
      "method": "email"
     },
     {
      "type": "eventResponse",
      "method": "email"
     }
    ]
}
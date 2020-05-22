public void removeUserRegistration(long userId){
     //remove the event from the given user 's event list 
     for(User user : userList){
          if(user.getId().equals(userId)){
               user.getEventRegistrations().removeIf(event->event.getId().equals(this.id));
           }
     }

     //remove given user from the event 's user list 
     //This will not have effects on DB record (as mentioned above) but suggest to also do it for keep the data in java model to be consistency.
     this.userList.removeIf(user -> user.getId() == userId);
 }
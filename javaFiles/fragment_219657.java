public static void addErrorMessage(Person person, String errorMessage){
      synchronized(person) {
          List<Message> msg = person.getMessageList();
          if(msg!=null){
             msg.add(buildMessage(errorMessage));
          }
      }
  }
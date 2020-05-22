List<SomeMessage> toRemove = new ArrayList<>();
for(SomeMessage message : priorityQueue){

          if(message.id == dead_sender.id){
                      toRemove.add(message);
       }
}
for (SomeMessage message : toRemove) { 
      priorityQueue.remove(message)
}
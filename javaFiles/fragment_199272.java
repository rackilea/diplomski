public void setStatus(String newStatus) {
    synchronize(this){
       myStatement();
       myOtherStatement();
       status = newStatus;
    }
  }
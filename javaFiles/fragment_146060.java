public String toString() {
        return String.format("|id: %10d |Name: %30s| Age: %02d | Tlf.: %d| Active: %s| Next Payment: %s |", id, getNameTrimmed() , age , tlfNo ,    activeMember, nextPayment );
 }

 private  String getNameTrimmed(){
    if(name.length()>30) {
        return name.substring(0,27)+"...";
    }
    return name;
}
public String receiveCall(CellPhone sender) {        
    // returns a String of the form:        
    // owner's name " is receiving a call from " sender's name        
    String receivingCall = ownerName + " is receiving a call from " + sender.getName();        
    return receivingCall;    
}

public String call(CellPhone receiver) {        
    // returns a String by using the receiver to invoke receiveCall        
    // while passing in the current phone        
    String invokingReceiveCall = receiver.receiveCall(this);        
    return invokingReceiveCall;    
}

public String getName() {
    return ownerName;
}
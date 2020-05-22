private boolean isValid;

public boolean getIsValid() { 
    return isValid;  
}

public String execute() {
    isValid = doProcessing();
    return "SUCCESS";
}
public boolean canWrite() { 
    return (
             (getState() == ConnectionState.OPEN) 
                     || (getState() == ConnectionState.CLOSING)) 
            && !isOutboundBusy() 
            && (getOutboundMessages().size() > 0); 
}
public void refresh(){
    synchronized(WhateverYourOuterClass.this){
        while(!datachanged){
            try {
                WhateverYourOuterClass.this.wait();
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        setRights();
        datachanged = false;            
    }
}
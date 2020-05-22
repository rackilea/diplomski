public CannonManager(ManCannon plugin) {
    CannonSet temp = null;
    try{
       // stuff happens
       temp = (CannonSet) in.readObject();
    }catch( ... ){
       // exception handling
    }
    if(temp == null){
       this.save = new CannonSet();
    }else{
       this.save = temp;
     }
 }
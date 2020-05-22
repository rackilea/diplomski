String unknown;
    try{
        unknown="cannot see me, why?";
    }catch(Exception e){
        e.printStackTrace();
        //return; // if you just want to give up with this method, but not bother breaking the flow of the caller
        throw new Exception("Uh-oh...", e); // if you want to be sure the caller knows something went wrong
    }
    System.out.println(unknown);
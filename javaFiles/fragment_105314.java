String unknown;
    try{
        unknown="cannot see me, why?";
    }catch(Exception e){
        e.printStackTrace();
        unknown = "exception caught";
    }
    System.out.println(unknown);
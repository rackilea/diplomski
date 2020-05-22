try{
        System.out.print(7/0);
    }catch(Exception e){
        System.out.println(e);
    }finally{
        System.out.println("no matter what I gonna be executed");
    }
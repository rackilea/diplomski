while(running){
        if(in.next().equalsIgnoreCase("exit")){
            running = false;
        }
        if(in.next().equalsIgnoreCase("Hello_World")){
            Hello_World.start();
        }
        if(in.next().equalsIgnoreCase("rps")){
            Rock_Paper_Scissors.start();
        }
    }
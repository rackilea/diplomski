final  StackImpl stack = new StackImpl(20);                     //(6) Shared by the threads


(new Thread("Pusher"){                                          //(7) Thread no. 1

    public void run(){

    int i = 0;

        for(;;){
            System.out.println("Pushed: " + stack.push(i++));
        }
    }
}).start();
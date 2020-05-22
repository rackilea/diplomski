Thread t = new Thread(new Runnable() {
    @Override
    public void run() {
       new GameInitializer(userName, player, Constants.BLIND_STRUCTURE_FILES.get(blindStructure), handState);       
    }

   });
t.start();
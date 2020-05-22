public void testTimeToServer(ApiCall api){
    watch.start();
    api.httpGetWithCallback("(my url)/api/v1/character", new CallBack(){
        @Override
        public void callback(String resp){
            System.out.println("Server Responded");
            time = watch.getTime();
            watch.stop();
            watch.reset();
            if(time > timeToDrop){
                Main.game.setScreen(new GameOverScreen(false));
                System.out.println("Should have switched screen")
            }
        }
    });
   }
}
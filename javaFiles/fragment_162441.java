new Thread(()->{
while(Main.running){
Platform.runLater(()->{

//updateui component
//this is updating on FXAT

});
Thread.sleep(time)//This way you dont let JFXAT wait
}
}).start();
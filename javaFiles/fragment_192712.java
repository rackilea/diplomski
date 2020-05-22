public abstract class MyGame extends Game {
     ...
     public IActivityRequestHandler handler;
     ...
     public MyGame(IActivityRequestHandler handler){
    this.handler = handler;
}
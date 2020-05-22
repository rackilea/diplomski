public static Turtle globalTurtle;
public static Thread serverInstance;

public static void main(String[] args){
    globalTurtle = new Turtle(NetworkHandler.getipByName("0.0.0.0"), 19132);
    serverInstance = new Thread(globalTurtle);
    serverInstance.start();
}
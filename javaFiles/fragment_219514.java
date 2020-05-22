@Path("/{startGame}")
@GET
@Produces(MediaType.TEXT_PLAIN)

public String startGame(){
    GameTimer timer = new GameTimer(1000);
    timer.start();
    return "Timer Started";
}
@Configuration
@EnableAspectJAutoProxy
public class Application {      
    @Bean
    public CommandService commandService(){
        return new CommandService();
    }

    @Bean
    public RoomService roomService(){
        return new RoomService();
    }

    @Bean
    public GameService gameService(){
        return new GameService();
    }

    @Bean
    @Scope("prototype")
    public AbstractRoom room(AbstractRoom.Mode roomMode){
        RoomService roomService = roomService();
        return roomService.newRoom(roomMode);
    }
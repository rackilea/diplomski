public class RoomService {

    @Autowired
    private ApplicationContext ctx;

    public AbstractRoom createRoom(String userID,int playerCount,Mode roomMode){
        AbstractRoom room = (AbstractRoom)ctx.getBean(AbstractRoom.class,roomMode);
    }
}
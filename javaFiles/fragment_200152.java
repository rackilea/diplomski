public class Instrument {
    private static int id = 0; // representing ID
    private int num = 0;
    private Room room ;
    private boolean status;
    private E_types type ;

    public Instrument(Room room, boolean status, E_Types type) {
        Instrument.id++;
        this.num = Instrument.id;
        this.room = room;
        this.status = status;
        this.type = type;
    }

    public static int getID() {
        return Instrument.id;
    }

    public int getNum() {
       return this.num;
    }
}